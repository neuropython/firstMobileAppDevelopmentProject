package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.caverock.androidsvg.SVG

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val intent = intent
        val numbersArray = intent.getIntArrayExtra("SELECTNUMBERS")


        val numberText = findViewById<TextView>(R.id.numView)
        numberText.text = "Here are my numbers: \n ${numbersArray?.joinToString("           ")}"

        val number1 = findViewById<TextView>(R.id.number1)
        val number2 = findViewById<TextView>(R.id.number2)
        val number3 = findViewById<TextView>(R.id.number3)
        val number4 = findViewById<TextView>(R.id.number4)
        val number5 = findViewById<TextView>(R.id.number5)
        val number6 = findViewById<TextView>(R.id.number6)


        val Button = findViewById<Button>(R.id.button)
        Button.setOnClickListener {
            val range = 0..5
            val winningNumbersList = MutableList(50) { it }
            val winningList = mutableListOf<Int>()
            for (number in range) {
                val random = winningNumbersList.random()
                winningNumbersList.remove(random)
                winningList.add(random)
                println(winningList)

        }
            number1.text = "${winningList[0]}"
            number2.text = "${winningList[1]}"
            number3.text = "${winningList[2]}"
            number4.text = "${winningList[3]}"
            number5.text = "${winningList[4]}"
            number6.text = "${winningList[5]}"

        }

    }

}