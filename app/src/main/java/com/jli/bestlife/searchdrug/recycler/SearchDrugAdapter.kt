package com.jli.bestlife.searchdrug.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jli.bestlife.R
import com.jli.bestlife.view.BaseAdapter

class SearchDrugAdapter : BaseAdapter<MedicationItem, MedicationSelectedEvent, MedicationItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_drug_item_view, parent, false)
        val viewHolder = MedicationItemViewHolder(view)
        observeViewHolderInput(viewHolder.getInputObservable())
        return viewHolder
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: MedicationItemViewHolder, position: Int) {
        holder.bind(MedicationItem("Random Drug"))
    }

    override fun addOrUpdateItems(items: List<MedicationItem>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

}