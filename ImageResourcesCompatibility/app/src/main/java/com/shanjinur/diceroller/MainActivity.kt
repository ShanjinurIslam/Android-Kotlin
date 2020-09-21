package com.shanjinur.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val resourceMap = mapOf<Int,Int>(1 to R.drawable.dice_1, 2 to R.drawable.dice_2,3 to R.drawable.dice_3,4 to R.drawable.dice_4,5 to R.drawable.dice_5,6 to R.drawable.dice_6)
    private lateinit var diceImage:ImageView // for later initialization
    /*

    val drawableResource = when (randomInt) {
       1 -> R.drawable.dice_1
       2 -> R.drawable.dice_2
       3 -> R.drawable.dice_3
       4 -> R.drawable.dice_4
       5 -> R.drawable.dice_5
       else -> R.drawable.dice_6
    }

     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton:Button = findViewById(R.id.rollButton)
        diceImage = findViewById(R.id.diceImage)

        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice(){
        val randomInt = (1..6).random()
        resourceMap[randomInt]?.let { diceImage.setImageResource(it) };
    }
}