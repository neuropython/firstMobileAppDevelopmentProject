package com.example.myapplication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val intent = intent
        val name = intent.getStringExtra("NAME")
        val email = intent.getStringExtra("EMAIL")
        val phone = intent.getStringExtra("PHONE")

        val welcomeText = findViewById<TextView>(R.id.textView2)
        welcomeText.text = "$name, please select your lucky numbers!"

        val numbersText = findViewById<TextView>(R.id.selectedNmbView)

        val numberPicker = findViewById<NumberPicker>(R.id.picker1)
        numberPicker.maxValue = 49
        numberPicker.minValue = 1

        val selectButton = findViewById<Button>(R.id.selectButton)
        val getRichButton = findViewById<Button>(R.id.getRichButton)
        getRichButton.isEnabled = false
        val numbersArray = MutableList<Int>(6) { 0 }
        var i = 0
        var text = ""
        numbersText.text = text
        selectButton.setOnClickListener {
            val selectedNumber = numberPicker.value
            if (selectedNumber !in numbersArray) {
                numbersArray[i++] = selectedNumber
                text += selectedNumber.toString()
                text = "$text   "
                numbersText.text = text
            }

            if (i >= numbersArray.size) {
                selectButton.isEnabled = false
                getRichButton.isEnabled = true
            } else {
                selectButton.text = "Another number!!"

            }
        }

        getRichButton.setOnClickListener {
                val intent = Intent(this,ThirdActivity::class.java )
                intent.putExtra("SELECTNUMBERS",numbersArray)
                startActivity(intent)
//            Make class
            }
        }






    }