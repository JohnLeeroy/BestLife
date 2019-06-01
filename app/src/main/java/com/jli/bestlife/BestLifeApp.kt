package com.jli.bestlife

import android.app.Application
import com.jli.bestlife.api.ApiConfig
import com.jli.bestlife.di.DiConfigurator
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import timber.log.Timber

class BestLifeApp : Application(), KodeinAware {

    override val kodein = configureDi()

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun getApiConfig(): ApiConfig {
        return object : ApiConfig {
            override val apiKey: String
                get() = BuildConfig.API_KEY
        }
    }

    private fun configureDi(): Kodein {
        return DiConfigurator().configureDi(this, getApiConfig())
    }
}