package com.shanjinur.budgetcost.data

import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.shanjinur.budgetcost.model.CostData
import com.shanjinur.budgetcost.view.CostAdapter

class DataSource() {
    val dataset:MutableList<CostData> = mutableListOf<CostData>();

    fun addToList(location:String,spent_amount:String){
        dataset.add(CostData(location,spent_amount))
    }
}