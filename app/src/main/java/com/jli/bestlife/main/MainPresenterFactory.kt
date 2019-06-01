package com.jli.bestlife.main

import com.jli.bestlife.api.DrugApiContract
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import org.ups.greensky.mvp.PresenterProvider

class MainPresenterFactory(kodein: Kodein) : PresenterProvider<MainView, MainPresenter>() {

    private val api : DrugApiContract by kodein.instance()

    override fun provide(): MainPresenter {
        return MainPresenter(api)
    }

}