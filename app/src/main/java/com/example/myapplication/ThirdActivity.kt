package com.example.myapplication

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.namespace.R
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import java.util.*
import kotlin.math.roundToInt


class ThirdActivity : AppCompatActivity() {

    private val numberList by lazy {
        listOf(
            findViewById<TextView>(R.id.number1),
            findViewById<TextView>(R.id.number2),
            findViewById<TextView>(R.id.number3),
            findViewById<TextView>(R.id.number4),
            findViewById<TextView>(R.id.number5),
            findViewById<TextView>(R.id.number6)
        )
    }

    private val winningLoosing by lazy {
        findViewById<TextView>(R.id.WinView)
    }

    private val rotationAnimators = mutableListOf<ObjectAnimator>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val intent = intent
        val UserEmail = intent.getStringExtra("EMAIL")
        val numbersArray = intent.getIntArrayExtra("SELECTNUMBERS") ?: intArrayOf()
        val numberText = findViewById<TextView>(R.id.numView)
        numberText.text = "Here are my numbers: \n ${numbersArray.joinToString(" ")}"

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val range = 0..5
            val winningNumbersList = MutableList(50) { it }
            val winningList = mutableListOf<Int>()

            for (number in range) {
                val random = winningNumbersList.random()
                winningNumbersList.remove(random)
                winningList.add(random)
            }

            animateBalls(winningList, numbersArray)

            val count = winningList.count { numbersArray.contains(it) }

            animateFadeIn(winningLoosing)


            val population = 100000
            for (i in 0..population) {
                val winningNumbersList = MutableList(50) { it }
                val populationList = mutableListOf<Int>()
                for (number in range) {
                    val random = winningNumbersList.random()
                    winningNumbersList.remove(random)
                    winningList.add(random)
                }

            }
            val threeNumbers = mutableListOf<List<Int>>()
            val fourNumbers = mutableListOf<List<Int>>()
            val fiveNumbers = mutableListOf<List<Int>>()
            val sixNumbers = mutableListOf<List<Int>>()

            val populationList = mutableListOf<List<Int>>()
            populationList.forEach { list ->
                when (winningList.count { list.contains(it) }) {
                    3 -> threeNumbers.add(list)
                    4 -> fourNumbers.add(list)
                    5 -> fiveNumbers.add(list)
                    6 -> sixNumbers.add(list)
                }
            }
            val threeNumbersProbability = threeNumbers.size.toDouble() / population
            val fourNumbersProbability = fourNumbers.size.toDouble() / population
            val fiveNumbersProbability = fiveNumbers.size.toDouble() / population
            val sixNumbersProbability = sixNumbers.size.toDouble() / population

            val threeNumbersPrice = if (threeNumbersProbability > 0) (100000.0 / threeNumbersProbability).roundToInt() else 0.0
            val fourNumbersPrice = if (fourNumbersProbability > 0) (100000.0 / fourNumbersProbability).roundToInt() else 0.0
            val fiveNumbersPrice = if (fiveNumbersProbability > 0) (1000000.0 / fiveNumbersProbability).roundToInt() else 0.0
            val sixNumbersPrice = if (sixNumbersProbability > 0) (10000000.0 / sixNumbersProbability).roundToInt() else 0.0

            when (count) {
                3 -> {
                    winningLoosing.text ="You won $threeNumbersPrice"
                    value_adder(UserEmail, threeNumbersPrice)
                }
                4 -> {winningLoosing.text = "You won $fourNumbersPrice"}
                5 -> {winningLoosing.text = "You won $fiveNumbersPrice"}
                6 -> {winningLoosing.text ="You won $sixNumbersPrice"}
                else -> {
                    winningLoosing.text = "You lost"
                }

            }
        }
    }


    private fun value_adder(UserEmail: String, winning_number: Comparable & Number) {
        val db = Firebase.firestore
        db.collection("Win_data")
            .add(UserEmail)

    }
    private fun animateBalls(winningList: List<Int>, numbersArray: IntArray) {
        // Stop any existing rotation animations
        stopRotationAnimations()

        for ((i, ball) in numberList.withIndex()) {
            ball.visibility = View.VISIBLE
            ball.text = "${winningList[i]}"

            val ballNumber = ball.text.toString().toIntOrNull()

            if (ballNumber != null && numbersArray.contains(ballNumber)) {
                animateFadeIn(ball)
                animateRotation(ball)
            } else {
                resetAnimations(ball)
            }
        }
    }

    private fun animateFadeIn(view: View) {
        val fadeIn = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        fadeIn.duration = 1000
        fadeIn.interpolator = AccelerateInterpolator()
        fadeIn.start()
    }

    private fun animateRotation(view: View) {
        val rotation = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f)
        rotation.duration = 1000
        rotation.repeatMode = ObjectAnimator.REVERSE
        rotation.repeatCount = ObjectAnimator.INFINITE
        rotation.start()

        // Save the rotation animator instance
        rotationAnimators.add(rotation)
    }

    private fun resetAnimations(view: View) {
        view.alpha = 1f
        view.rotation = 0f
    }

    private fun stopRotationAnimations() {
        // Stop any existing rotation animations
        for (animator in rotationAnimators) {
            animator.cancel()
        }
        // Clear the list
        rotationAnimators.clear()
    }

    private fun animateView(view: View) {
        resetAnimations(view)
        val shake = ObjectAnimator.ofFloat(view, "translationX", 0f, 25f, -25f, 25f, -25f, 15f, -15f, 6f, -6f, 0f)
        shake.duration = 1000
        shake.interpolator = AccelerateInterpolator()
        shake.start()
    }
}