package com.jli.bestlife.searchdrug

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jli.bestlife.BestLifeApp
import com.jli.bestlife.R
import com.jli.bestlife.domain.Drug
import com.jli.bestlife.medication.AddMedicationFormActivity
import com.jli.bestlife.mvp.BaseMVPActivity
import com.jli.bestlife.searchdrug.recycler.SearchDrugAdapter
import io.reactivex.Observable
import org.ups.greensky.mvp.PresenterProvider


class SearchDrugActivity : BaseMVPActivity<SearchDrugView, SearchDrugPresenter>(), SearchDrugView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_drug)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        recyclerView = findViewById(R.id.search_result_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun setAdapter(adapter: SearchDrugAdapter) {
        recyclerView.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        searchView = menu.findItem(R.id.search).actionView as SearchView
        return true
    }

    override val presenterProvider: PresenterProvider<SearchDrugView, SearchDrugPresenter>
        get() = SearchDrugPresenterFactory((application as BestLifeApp).kodein)

    override fun goToMedicationForm(drug: Drug) {
        AddMedicationFormActivity.start(this, drug)
    }

    override fun getSearchViewActions(): Observable<RxSearchView.RxSearchActionEvent> {
        return RxSearchView.onQueryActions(searchView)
    }
}
