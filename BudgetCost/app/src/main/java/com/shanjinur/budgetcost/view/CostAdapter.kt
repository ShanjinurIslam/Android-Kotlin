package com.shanjinur.budgetcost.view

import android.content.Context
import android.view.LayoutInflater
import com.shanjinur.budgetcost.R
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shanjinur.budgetcost.model.CostData

class CostAdapter(private val context: Context,private val dataset:MutableList<CostData>):RecyclerView.Adapter<CostAdapter.CostItemViewHolder>() {
    class CostItemViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        val locationTextView:TextView = view.findViewById(R.id.location_name)
        val spentAmountTextView:TextView = view.findViewById(R.id.spent_amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CostItemViewHolder {
        val adapterLayout = LayoutInflater.from(context).inflate(R.layout.cost_item_row,parent,false)
        return CostItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: CostItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.locationTextView.text = dataset[position].location_name
        holder.spentAmountTextView.text = dataset[position].spent_amount
    }
}