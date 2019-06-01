package com.jli.bestlife.searchdrug

import com.jli.bestlife.mvp.BaseView
import io.reactivex.Observable

interface SearchDrugView : BaseView {

//    fun showNoResultsMessage(message: String)
//
//    fun hideNoResultsMessage()
//
//    fun getSearchActionEvent(): Observable<RxSearchView.RxSearchActionEvent>

    fun goToMedicationForm()
}