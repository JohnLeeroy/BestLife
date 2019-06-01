package com.jli.bestlife.searchdrug

import com.jli.bestlife.mvp.BaseView
import com.jli.bestlife.searchdrug.recycler.SearchDrugAdapter

interface SearchDrugView : BaseView {

    fun goToMedicationForm()

    fun setAdapter(adapter: SearchDrugAdapter)
}