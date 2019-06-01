package com.jli.bestlife.searchdrug

import com.jli.bestlife.domain.Drug
import com.jli.bestlife.mvp.BaseView
import com.jli.bestlife.searchdrug.recycler.SearchDrugAdapter
import io.reactivex.Observable

interface SearchDrugView : BaseView {

    fun goToMedicationForm(drug: Drug)

    fun setAdapter(adapter: SearchDrugAdapter)

    fun getSearchViewActions(): Observable<RxSearchView.RxSearchActionEvent>

}