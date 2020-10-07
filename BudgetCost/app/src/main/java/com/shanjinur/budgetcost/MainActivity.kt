package com.shanjinur.budgetcost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.shanjinur.budgetcost.data.DataSource
import com.shanjinur.budgetcost.view.CostAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var dataSource:DataSource
    private lateinit var adapter: CostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        dataSource = DataSource();
        adapter = CostAdapter(this,dataSource.dataset)

        val recyclerView:RecyclerView = findViewById(R.id.recycler_view)

        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    fun addCost(view: View) {
        dataSource.addToList("Starbucks","$30")
        adapter.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_clear -> {
                dataSource.dataset.clear()
                adapter.notifyDataSetChanged()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}