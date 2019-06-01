package com.jli.bestlife.main

import com.jli.bestlife.mvp.BaseView
import com.jli.bestlife.searchdrug.recycler.MedicationAdapter
import com.jli.bestlife.searchdrug.recycler.MedicationItem

interface MainView : BaseView {

    fun navigateToAddDrug()

    fun setupAdapter(adapter: MedicationAdapter)

    fun openMedicationDetailView(item: MedicationItem)

}