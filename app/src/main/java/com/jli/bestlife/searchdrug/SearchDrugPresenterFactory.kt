package com.jli.bestlife.searchdrug

import com.jli.bestlife.api.DrugApiContract
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.ups.greensky.mvp.PresenterProvider

class SearchDrugPresenterFactory(kodein: Kodein) : PresenterProvider<SearchDrugView, SearchDrugPresenter>() {

    private val api : DrugApiContract by kodein.instance()

    override fun provide(): SearchDrugPresenter {
        return SearchDrugPresenter(api)
    }

}