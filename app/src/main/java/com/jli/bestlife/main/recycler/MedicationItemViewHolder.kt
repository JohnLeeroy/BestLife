package com.jli.bestlife.searchdrug.recycler

import android.view.View
import android.widget.TextView
import com.jakewharton.rxbinding3.view.clicks
import com.jli.bestlife.R
import com.jli.bestlife.view.BaseViewHolder
import io.reactivex.Observable

class MedicationItemViewHolder(itemView: View) : BaseViewHolder<MedicationItem, MedicationSelectedEvent>(itemView) {

    private val medicationNameLabel : TextView = itemView.findViewById(R.id.medication_name)
    private val medicationFrequencyLabel : TextView = itemView.findViewById(R.id.medication_frequency)
    private val medicationRefillLabel : TextView = itemView.findViewById(R.id.medication_refill_reminder)

    override fun bind(model: MedicationItem) {
        super.bind(model)
        medicationNameLabel.text = model.userMedication.drug.genericName.plus(" - ").plus(model.userMedication.dosage)
        medicationFrequencyLabel.text = model.userMedication.frequency
        medicationRefillLabel.text = "Refill date ".plus(model.userMedication.refillDate)
    }

    override fun getInputObservable(): Observable<MedicationSelectedEvent> {
        return itemView.clicks().map { model?.userMedication?.let { userMed -> MedicationSelectedEvent(userMed) } }
    }

}