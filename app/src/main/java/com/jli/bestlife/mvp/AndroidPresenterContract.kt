package com.jli.bestlife.mvp

import android.os.Bundle

interface AndroidPresenterContract {
  fun onAttach()
  fun onDetach()
  fun save(bundle: Bundle): Bundle
  fun load(bundle: Bundle)
}