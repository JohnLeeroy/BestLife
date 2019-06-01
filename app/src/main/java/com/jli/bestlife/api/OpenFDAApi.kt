package com.jli.bestlife.api

import com.jli.bestlife.api.model.DrugLabelResponse
import io.reactivex.Observable

class OpenFDAApi(private val openFDAService: OpenFDAService) : DrugApiContract {

    override fun searchDrugLabel(name: String): Observable<DrugLabelResponse> {
        return openFDAService.getUpcomingWeeklyForecast(name, 20)
    }

}