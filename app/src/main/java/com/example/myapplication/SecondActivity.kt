package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    var nextViewButton: Button? = null
    private fun openMainActivity() {
        val intent = Intent(this, MainActivity()::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second) // Use the correct layout for SecondActivity

        val textView = findViewById<TextView>(R.id.hello)

        val receivedText = intent.getStringExtra("text_key")
        if (receivedText != null) {
            textView.text = "hello $receivedText"
        }


        nextViewButton = findViewById(R.id.nextViewBtn)
        nextViewButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                openMainActivity()
            }
        })
    }
}
