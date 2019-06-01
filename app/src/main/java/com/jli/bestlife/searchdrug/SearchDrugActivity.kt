package com.jli.bestlife.searchdrug

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jli.bestlife.R
import com.jli.bestlife.medical.AddMedicationFormActivity
import com.jli.bestlife.mvp.BaseMVPActivity
import com.jli.bestlife.searchdrug.recycler.MedicationAdapter
import org.ups.greensky.mvp.PresenterProvider
import timber.log.Timber

class SearchDrugActivity : BaseMVPActivity<SearchDrugView, SearchDrugPresenter>(), SearchDrugView {

    private lateinit var recyclerView: RecyclerView
    val adapter = MedicationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_drug)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.search_result_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.getInputObservable()
            .subscribe({
                goToMedicationForm()
            }, Timber::d)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return true
    }

    override val presenterProvider: PresenterProvider<SearchDrugView, SearchDrugPresenter>
        get() = SearchDrugPresenterFactory()

    override fun goToMedicationForm() {
        val intent = Intent(this, AddMedicationFormActivity::class.java)
        startActivity(intent)
    }

}
