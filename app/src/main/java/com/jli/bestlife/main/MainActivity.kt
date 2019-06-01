package com.jli.bestlife.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.jli.bestlife.BestLifeApp
import com.jli.bestlife.R
import com.jli.bestlife.medical.MedicationDetailActivity
import com.jli.bestlife.mvp.BaseMVPActivity
import com.jli.bestlife.searchdrug.SearchDrugActivity
import com.jli.bestlife.searchdrug.recycler.MedicationAdapter
import com.jli.bestlife.searchdrug.recycler.MedicationItem
import kotlinx.android.synthetic.main.activity_main.*
import org.ups.greensky.mvp.PresenterProvider

class MainActivity : BaseMVPActivity<MainView, MainPresenter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun openMedicationDetailView(item: MedicationItem) {
        val intent = Intent(this, MedicationDetailActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToAddDrug() {
        val intent = Intent(this, SearchDrugActivity::class.java)
        startActivity(intent)
    }

    override fun setupAdapter(adapter: MedicationAdapter) {
        medication_recycler_view.layoutManager = LinearLayoutManager(this)
        medication_recycler_view.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add_medication) {
          navigateToAddDrug()
        }
        return super.onOptionsItemSelected(item)
    }

    override val presenterProvider: PresenterProvider<MainView, MainPresenter>
        get() = MainPresenterFactory((application as BestLifeApp).kodein)
}
