package com.jli.bestlife.searchdrug

import com.jli.bestlife.mvp.BasePresenter
import com.jli.bestlife.searchdrug.recycler.SearchDrugAdapter
import timber.log.Timber

class SearchDrugPresenter : BasePresenter<SearchDrugView>() {

    lateinit var searchDrugAdapter: SearchDrugAdapter

    override fun onAttach() {
        searchDrugAdapter = SearchDrugAdapter()
        view?.setAdapter(searchDrugAdapter)

        searchDrugAdapter.getInputObservable()
            .subscribe({
                view?.goToMedicationForm()
            }, Timber::d)
    }

    override fun onDetach() {
    }
}