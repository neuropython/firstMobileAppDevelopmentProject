package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.ImageView as imageView
import java.io.IOException
import com.example.namespace.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent

        val switchView = findViewById<Switch>(R.id.ageswitch)
        val buttonGame = findViewById<Button>(R.id.selectButton)
        buttonGame.isEnabled = false

        switchView.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                buttonGame.isEnabled = isChecked
                buttonGame.text = "YES"
            } else {
                buttonGame.text = "NO"
            }
        }

        val inputName = findViewById<EditText>(R.id.editTextText)
        val inputMail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val inputPhote = findViewById<EditText>(R.id.editTextPhone)


        buttonGame.setOnClickListener {

            var name = inputName.text.toString()
            if (name.isEmpty()) {
                name = "unknown"
            }
            var email = inputMail.text.toString()
            if (email.isEmpty()) {
                email = "unknown"
            }
            var phone = inputMail.text.toString()
            if (phone.isEmpty()) {
                phone = "unknown"
            }
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("NAME",name)
            intent.putExtra("EMAIL",email)
            intent.putExtra("PHONE",phone)
            startActivity(intent)
        }

    }
}