package com.jli.bestlife.di

import android.content.Context
import com.jli.bestlife.api.ApiConfig
import com.jli.bestlife.api.DrugApiContract
import com.jli.bestlife.api.OpenFDApiFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class DiConfigurator {

    fun configureDi(applicationContext: Context, apiConfig: ApiConfig) : Kodein {
        return Kodein.lazy {
            bind<Context>() with instance(applicationContext)
            bind<ApiConfig>() with instance(apiConfig)
            bind<DrugApiContract>() with singleton { OpenFDApiFactory().make(apiConfig) }
        }
    }
}