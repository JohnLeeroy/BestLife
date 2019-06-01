package com.jli.bestlife.main

import android.os.Bundle
import com.jli.bestlife.BestLifeApp
import com.jli.bestlife.R
import com.jli.bestlife.mvp.BaseMVPActivity
import org.ups.greensky.mvp.PresenterProvider

class MainActivity : BaseMVPActivity<MainView, MainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override val presenterProvider: PresenterProvider<MainView, MainPresenter>
        get() = MainPresenterFactory((application as BestLifeApp).kodein)


}
