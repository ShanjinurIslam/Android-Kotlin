package com.shanjinur.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton:Button = findViewById(R.id.roll_button)
        val resultString:TextView = findViewById(R.id.result_string)

        resultString.text = "Please roll to start rolling"

        rollButton.setOnClickListener { rollDice(resultString) }
    }

    private fun rollDice(resultString:TextView){

        val randomInt = (1..6).random()
        resultString.text = randomInt.toString()
    }
}