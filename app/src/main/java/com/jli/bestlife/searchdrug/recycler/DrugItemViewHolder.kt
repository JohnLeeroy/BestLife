package com.jli.bestlife.searchdrug.recycler

import android.view.View
import android.widget.TextView
import com.jakewharton.rxbinding3.view.clicks
import com.jli.bestlife.R
import com.jli.bestlife.view.BaseViewHolder
import io.reactivex.Observable

class DrugItemViewHolder(itemView: View) : BaseViewHolder<DrugItem, DrugSelectedEvent>(itemView) {

    val drugLabel : TextView = itemView.findViewById(R.id.drug_name_label)

    override fun bind(model: DrugItem) {
        super.bind(model)
        drugLabel.text = model.drug.brandName
    }

    override fun getInputObservable(): Observable<DrugSelectedEvent> {
        return itemView.clicks().map {
            model?.let { model -> DrugSelectedEvent(model.drug) }
        }
    }

}