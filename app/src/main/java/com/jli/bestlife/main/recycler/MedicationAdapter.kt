package com.jli.bestlife.searchdrug.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jli.bestlife.R
import com.jli.bestlife.view.BaseAdapter

class MedicationAdapter : BaseAdapter<MedicationItem, MedicationSelectedEvent, MedicationItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_medication_item_view, parent, false)
        val viewHolder = MedicationItemViewHolder(view)
        observeViewHolderInput(viewHolder.getInputObservable())
        return viewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MedicationItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun addOrUpdateItems(items: List<MedicationItem>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

}