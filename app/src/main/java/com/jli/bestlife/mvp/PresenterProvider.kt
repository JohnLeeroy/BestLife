package org.ups.greensky.mvp

import com.jli.bestlife.mvp.BasePresenter
import com.jli.bestlife.mvp.BaseView

abstract class PresenterProvider<VIEW : BaseView, out PRESENTER : BasePresenter<VIEW>> {

  abstract fun provide(): PRESENTER

}