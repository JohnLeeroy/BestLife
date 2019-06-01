package com.jli.bestlife.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Response


class OpenFDApiFactory {

    fun make(apiConfig: ApiConfig): OpenFDAApi {

        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request().newBuilder().addHeader("api_key", apiConfig.apiKey).build()
                return chain.proceed(request)
            }
        })

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(clientBuilder.build())
            .build()
        val darkSkyService = retrofit.create(OpenFDAService::class.java)
        return OpenFDAApi(darkSkyService)
    }

    companion object {
        private const val baseUrl = "https://api.fda.gov/drug/"
    }
}