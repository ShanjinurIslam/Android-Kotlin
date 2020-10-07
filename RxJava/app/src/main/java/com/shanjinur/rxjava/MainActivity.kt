package com.shanjinur.rxjava

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.shanjinur.rxjava.app.Const
import com.shanjinur.rxjava.network.ApiClient
import com.shanjinur.rxjava.network.ApiService
import com.shanjinur.rxjava.network.model.Note
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, Const.BASE_URL, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val apiService:ApiService = ApiClient.getClient(applicationContext).create(ApiService::class.java)

        apiService.fetchAllNotes()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribeWith(object : DisposableSingleObserver<List<Note?>?>() {
                override fun onSuccess(notes: List<Note?>) {
                    // Received all notes
                }

                override fun onError(e: Throwable) {
                    // Network error
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}