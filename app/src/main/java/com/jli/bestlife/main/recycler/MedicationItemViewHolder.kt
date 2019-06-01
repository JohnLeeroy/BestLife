package com.jli.bestlife.searchdrug.recycler

import android.view.View
import android.widget.TextView
import com.jakewharton.rxbinding3.view.clicks
import com.jli.bestlife.R
import com.jli.bestlife.view.BaseViewHolder
import io.reactivex.Observable

class MedicationItemViewHolder(itemView: View) : BaseViewHolder<MedicationItem, MedicationSelectedEvent>(itemView) {

    private val drugLabel : TextView = itemView.findViewById(R.id.drug_name_label)

    override fun bind(model: MedicationItem) {
        super.bind(model)
        drugLabel.text = model.name
    }

    override fun getInputObservable(): Observable<MedicationSelectedEvent> {
        return itemView.clicks().map { MedicationSelectedEvent(drugLabel.text.toString()) }
    }

}