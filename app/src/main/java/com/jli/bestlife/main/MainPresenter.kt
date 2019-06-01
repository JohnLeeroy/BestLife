package com.jli.bestlife.main

import com.jli.bestlife.api.DrugApiContract
import com.jli.bestlife.mvp.BasePresenter
import com.jli.bestlife.searchdrug.recycler.MedicationAdapter
import com.jli.bestlife.searchdrug.recycler.MedicationItem
import timber.log.Timber

class MainPresenter(private val drugApi: DrugApiContract) : BasePresenter<MainView>() {

    lateinit var adapter: MedicationAdapter

    override fun onAttach() {
//        drugApi.searchDrugLabel("benadryl")
//            .subscribeOn(Schedulers.newThread())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                Timber.d(it.toString())
//            }, Timber::d)
//
        adapter = MedicationAdapter()
        view?.setupAdapter(adapter)
        adapter.getInputObservable()
            .subscribe({ view?.openMedicationDetailView(MedicationItem("")) }, Timber::d)
    }

    override fun onDetach() {

    }
}