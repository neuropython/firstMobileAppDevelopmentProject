package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val intent = intent
        val numbersArray = intent.getIntArrayExtra("SELECTNUMBERS")


        val numberText = findViewById<TextView>(R.id.numView)
        numberText.text = "Here are my numbers: \n ${numbersArray?.joinToString("           ")}"

        val winningValues = findViewById<TextView>(R.id.winningValues)

        val Button = findViewById<Button>(R.id.button)
        Button.setOnClickListener {
            val range = 0..5
            val winningNumbersList = MutableList(50) { it }
            val winningList = mutableListOf<Int>()
            for (number in range) {
                val random = winningNumbersList.random()
                winningNumbersList.remove(random)
                winningList.add(random)

        }
            val text = winningList.joinToString("           ")
            winningValues.text = "Here are the winning numbers: \n $text"
        }

    }

}