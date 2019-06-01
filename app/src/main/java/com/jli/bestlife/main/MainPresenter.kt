package com.jli.bestlife.main

import com.jli.bestlife.api.DrugApiContract
import com.jli.bestlife.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MainPresenter(private val drugApi : DrugApiContract) : BasePresenter<MainView>() {

    override fun onAttach() {
        drugApi.searchDrugLabel("benadryl")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Timber.d(it.toString())
            }, Timber::d)
    }

    override fun onDetach() {

    }
}