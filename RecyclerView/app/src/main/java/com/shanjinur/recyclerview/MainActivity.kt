package com.shanjinur.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.shanjinur.recyclerview.data.DataSource
import com.shanjinur.recyclerview.view.AffirmationAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = DataSource.loadAffirmations();

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = AffirmationAdapter(this, myDataset)
        recyclerView.setHasFixedSize(true)
    }
}