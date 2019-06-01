package com.jli.bestlife.searchdrug.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jli.bestlife.R
import com.jli.bestlife.view.BaseAdapter

class SearchDrugAdapter : BaseAdapter<DrugItem, DrugSelectedEvent, DrugItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrugItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.layout_drug_item_view, parent, false)
        val viewHolder = DrugItemViewHolder(view)
        observeViewHolderInput(viewHolder.getInputObservable())
        return viewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DrugItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun addOrUpdateItems(items: List<DrugItem>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

}