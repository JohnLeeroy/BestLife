package com.jli.bestlife.domain

import java.io.Serializable

data class Drug(val brandName: String,
                val genericName: String,
                val manufacturer: String,
                val effectiveTime: Long,
                val activeIngredient: String,
                val askDoctorWarning: String,
                val dosageInstruction: String,
                val inactiveIngredients: String,
                val usageDescription: String,
                val generalWarning: String,
                val keepAwayWarning: String,
                val safetyInformation: String) : Serializable