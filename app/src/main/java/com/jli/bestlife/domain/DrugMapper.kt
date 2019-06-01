package com

import com.jli.bestlife.api.model.Result
import com.jli.bestlife.domain.Drug

class DrugMapper {
    companion object {
        fun map(result: Result) : Drug {
            return Drug(result?.openfda?.brandName?.firstOrNull() ?: "",
                result?.openfda?.genericName?.firstOrNull() ?: "",
                result?.effectiveTime?.toLong() ?: 0,
                result?.activeIngredient?.firstOrNull() ?: "",
                result?.askDoctor?.firstOrNull() ?: "",
                result?.dosageAndAdministration?.firstOrNull() ?: "",
                result?.inactiveIngredient?.firstOrNull() ?: "",
                result?.indicationsAndUsage?.firstOrNull() ?: "",
                result?.warnings?.firstOrNull() ?: "",
                result?.keepOutOfReachOfChildren?.firstOrNull() ?: "",
                result?.otherSafetyInformation?.firstOrNull() ?: "")
        }
    }
}