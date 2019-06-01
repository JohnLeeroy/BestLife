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
                ?.subscribe({
                    when (it.type) {
                        RxSearchViewActionEvent.SUBMIT -> {
                            searchDrugLabel(it.text)
                        }
                    }
                }, Timber::d)
        }, 1000)
    }

    private fun searchDrugLabel(string: String) {
        api.searchDrugLabel(string)
            .map { DrugMapper.map(it.results.first()) }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d(it.toString())
                searchDrugAdapter.addOrUpdateItems(mutableListOf(DrugItem(it)))
            }, Timber::e)
    }

    override fun onDetach() {

    }
}