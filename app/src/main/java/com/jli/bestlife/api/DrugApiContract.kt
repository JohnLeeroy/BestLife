package com.jli.bestlife.api

import com.jli.bestlife.api.model.DrugLabelResponse
import io.reactivex.Observable

interface DrugApiContract {

    fun searchDrugLabel(name: String) : Observable<DrugLabelResponse>
}