package com.shanjinur.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    var last_close_time:Int = 0 ;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState!=null) {
            last_close_time = savedInstanceState.getInt("LAST_CLOSE_TIME")
        }

        setContentView(R.layout.activity_main)

        Timber.i("onCreate Called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("LAST_CLOSE_TIME",1)
        super.onSaveInstanceState(outState)
    }


}