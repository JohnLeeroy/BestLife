package com.jli.bestlife.searchdrug

import android.os.Handler
import com.DrugMapper
import com.jli.bestlife.api.DrugApiContract
import com.jli.bestlife.mvp.BasePresenter
import com.jli.bestlife.searchdrug.recycler.DrugItem
import com.jli.bestlife.searchdrug.recycler.SearchDrugAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SearchDrugPresenter(private val api: DrugApiContract) : BasePresenter<SearchDrugView>() {

    lateinit var searchDrugAdapter: SearchDrugAdapter

    override fun onAttach() {
        initSearchAdapter()
        observeSearchEvents()
    }

    private fun initSearchAdapter() {
        searchDrugAdapter = SearchDrugAdapter()
        view?.setAdapter(searchDrugAdapter)
        searchDrugAdapter.getInputObservable()
            .subscribe({
                view?.goToMedicationForm(it.drug)
            }, Timber::e)
    }

    private fun observeSearchEvents() {
        val handler = Handler()
        handler.postDelayed({
            view?.getSearchViewActions()
                ?.filter { it.type == RxSearchViewActionEvent.SUBMIT }
                ?.subscribe({ searchDrugLabel(it.text) }, Timber::d)

            view?.getSearchViewActions()
                ?.filter { it.type == RxSearchViewActionEvent.QUERY_CHANGE }
                ?.debounce(1000, TimeUnit.MILLISECONDS)
                ?.subscribe({ searchDrugLabel(it.text) }, Timber::d)

        }, 1000)
    }

    private fun searchDrugLabel(string: String) {
        api.searchDrugLabel(string)
            .map { DrugMapper.map(it.results) }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val drugItems = mutableListOf<DrugItem>()
                it.filter { it.brandName.isNotEmpty() || it.brandName.isNotEmpty() }
                    .forEach { drug -> drugItems.add(DrugItem(drug)) }
                searchDrugAdapter.addOrUpdateItems(drugItems)
            }, Timber::e)
    }

    override fun onDetach() {

    }
}