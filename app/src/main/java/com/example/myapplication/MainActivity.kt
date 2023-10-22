package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.view.View

class MainActivity : AppCompatActivity() {
    // Variable declaration
    private var nextViewButton: Button? = null
    private var storedText: String? = null
    var nameString: String? = null




    private fun openSecondActivity(nameString: String) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("text_key", storedText) // "text_key" is a key to identify the text
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTxt = findViewById<EditText>(R.id.editTextText)
        editTxt.setText("please tell me your name") // Use setText to set text for EditText
        val inputText = editTxt.text.toString()
        // Locating a button in the user interface based on its ID
        nextViewButton = findViewById(R.id.nextViewBtn)
        nextViewButton?.setOnClickListener {
            storedText = editTxt.text.toString()
            openSecondActivity(storedText!!)

        }
    }
}
