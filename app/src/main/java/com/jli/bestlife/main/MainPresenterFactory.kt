package com.jli.bestlife.main

import org.ups.greensky.mvp.PresenterProvider

class MainPresenterFactory() : PresenterProvider<MainView, MainPresenter>() {

    override fun provide(): MainPresenter {
        return MainPresenter()
    }

}