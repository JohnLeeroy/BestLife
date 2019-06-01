package com.jli.bestlife.domain

data class UserMedication(
    val drug: Drug,
    val dosage : String,
    val frequency: String,
    val refillDate: String)