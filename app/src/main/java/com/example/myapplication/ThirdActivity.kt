package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.coroutines.runBlocking
import com.example.namespace.R
import kotlin.random.Random


class ThirdActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val intent = intent
        val random = Random
        val numbersArray = intent.getIntArrayExtra("SELECTNUMBERS")


        val numberText = findViewById<TextView>(R.id.numView)
        numberText.text = "Here are my numbers: \n ${numbersArray?.joinToString(" ")}"

        val number1 = findViewById<TextView>(R.id.number1)
        val number2 = findViewById<TextView>(R.id.number2)
        val number3 = findViewById<TextView>(R.id.number3)
        val number4 = findViewById<TextView>(R.id.number4)
        val number5 = findViewById<TextView>(R.id.number5)
        val number6 = findViewById<TextView>(R.id.number6)

        val ListWithThree = mutableListOf<List<Int>>()
        val ListWithFour = mutableListOf<List<Int>>()
        val ListWithFive = mutableListOf<List<Int>>()
        val ListWithSix = mutableListOf<List<Int>>()


        val winningLoosing = findViewById<TextView>(R.id.WinView)


        val numberList = mutableListOf<TextView>(
            number1, number2, number3, number4, number5, number6
        )


        val Button = findViewById<Button>(R.id.button)
        Button.setOnClickListener {
            val range = 0..5
            val winningNumbersList = MutableList(50) { it }
            val winningList = mutableListOf<Int>()
            var i = 0
            for (number in range) {
                val random = winningNumbersList.random()
                winningNumbersList.remove(random)
                winningList.add(random)
            }
            runBlocking {
                for (ball in numberList) {
                    ball.visibility = View.VISIBLE
                    ball.text = "${winningList[i]}"
                    YoYo.with(Techniques.Landing).duration(1000).playOn(ball)
                    i++
                }}


            for (number in numbersArray!!) {
                for (ball in numberList) {
                    if (number == ball.text.toString().toInt()) {
                        YoYo.with(Techniques.Wobble).duration(3000).playOn(ball)
                    }
                }
                val numbersList = numbersArray?.toMutableList() ?: mutableListOf()

                if (numbersList == winningList) {
                    winningLoosing.text = "YOU WON!!!"
                    YoYo.with(Techniques.Flash).duration(3000).playOn(winningLoosing)
                } else {
                    winningLoosing.text = "YOU LOST!!!"
                    YoYo.with(Techniques.Flash).duration(3000).playOn(winningLoosing)
                }
                fun population() {
                    val population = 1000000
                    val populationList = mutableListOf<List<Int>>()
//                    write random list consisting of six numbers from 1 to 49
                    for (i in 1..population) {
                        val randomList = List(6) {
                            random.nextInt(1, 50) // Generates a random number between 1 (inclusive) and 50 (exclusive)
                        }
                        populationList.add(randomList)
                    }
                    val winningList = mutableListOf<Int>()
                    var i = 0
                    for (number in range) {
                        val random = winningNumbersList.random()
                        winningNumbersList.remove(random)
                        winningList.add(random)
                    }
                    populationList.forEach { list ->
                        var count = 0
                        winningList.forEach { number ->
                            if (list.contains(number)) {
                                count++
                            }
                        }
                        if (count == 3) {
                            val ListWithThree = mutableListOf<List<Int>>()
                            ListWithThree.add(list)
                        }
                        if (count == 4) {
                            val ListWithFour= mutableListOf<List<Int>>()
                            ListWithFour.add(list)
                        }
                        if (count == 5) {
                            val ListWithFive = mutableListOf<List<Int>>()
                            ListWithFive.add(list)
                        }
                        if (count == 6) {
                            val ListWithSix = mutableListOf<List<Int>>()
                            ListWithSix.add(list)
                        }
                    }


                }


            }
        }

    }}