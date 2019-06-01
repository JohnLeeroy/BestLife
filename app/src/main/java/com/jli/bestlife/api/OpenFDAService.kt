package com.jli.bestlife.api

import com.jli.bestlife.api.model.DrugLabelResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenFDAService {

    @GET("label.json")
    fun getUpcomingWeeklyForecast(
        @Query("search") searchField: String,
        @Query("limit") limit: Int
    ): Observable<DrugLabelResponse>
}