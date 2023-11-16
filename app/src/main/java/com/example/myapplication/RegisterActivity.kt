package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.namespace.R
//import intent
import android.content.Intent
//import button
import android.widget.Button
//import switch
import android.widget.Switch

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val register = findViewById<Button>(R.id.logIn)
        val switch = findViewById<Switch>(R.id.switch1)
//        create click listener for register button
        register.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
//           create click listener for switch
            switch.setOnClickListener {
                if (switch.isChecked) {
                    register.isEnabled = true
                } else {
                    register.isEnabled = false
                }
            }
        }
    }
}