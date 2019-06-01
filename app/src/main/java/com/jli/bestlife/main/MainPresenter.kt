package com.jli.bestlife.main

import com.jli.bestlife.MedicationStore
import com.jli.bestlife.api.DrugApiContract
import com.jli.bestlife.mvp.BasePresenter
import com.jli.bestlife.searchdrug.recycler.MedicationAdapter
import com.jli.bestlife.searchdrug.recycler.MedicationItem

class MainPresenter(private val drugApi: DrugApiContract,
                    private val medicationStore: MedicationStore) : BasePresenter<MainView>() {

    lateinit var adapter: MedicationAdapter

    override fun onAttach() {
        medicationStore.loadMedicationList()
        var medicationItemList = mutableListOf<MedicationItem>()
        var medicationlist = medicationStore.getMedicationList()
        medicationlist.forEach {
            medicationItemList.add(MedicationItem(it))
        }
        adapter = MedicationAdapter()
        view?.setupAdapter(adapter)
        adapter.addOrUpdateItems(medicationItemList)

//        adapter.getInputObservable()
//            .subscribe({ view?.openMedicationDetailView(MedicationItem()) }, Timber::d)
    }

    override fun onDetach() {

    }
}