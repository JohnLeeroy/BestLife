package com.jli.bestlife.searchdrug

import org.ups.greensky.mvp.PresenterProvider


class SearchDrugPresenterFactory : PresenterProvider<SearchDrugView, SearchDrugPresenter>() {

    override fun provide(): SearchDrugPresenter {
        return SearchDrugPresenter()
    }

}