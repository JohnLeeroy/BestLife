package com.jli.bestlife

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jli.bestlife.domain.UserMedication

class MedicationStore constructor(val sharedPreferences: SharedPreferences) {

    private val storeKey = "medicationList"
    private val gson = Gson()
    private var userMedicationList = mutableListOf<UserMedication>()

    init {
        loadMedicationList()
    }

    fun addMedication(userMedication: UserMedication) {
        userMedicationList.add(userMedication)
        saveMedicationList()
    }

    private fun saveMedicationList() {
        sharedPreferences.edit()
            .putString(storeKey, gson.toJson(userMedicationList))
            .commit()
    }

    fun loadMedicationList() {
        val listType = object : TypeToken<List<UserMedication>>() { }.type
        val json = sharedPreferences.getString(storeKey, "[]")
        userMedicationList = gson.fromJson(json, listType)

    }

    fun getMedicationList() : List<UserMedication> {
        return userMedicationList
    }
}