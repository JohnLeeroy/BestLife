package com.jli.bestlife.di

import android.content.Context
import com.jli.bestlife.ApiConfig
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance

class DiConfigurator {

    fun configureDi(applicationContext: Context, apiConfig: ApiConfig) : Kodein {
        return Kodein.lazy {
            bind<Context>() with instance(applicationContext)
            bind<ApiConfig>() with instance(apiConfig)
        }
    }
}