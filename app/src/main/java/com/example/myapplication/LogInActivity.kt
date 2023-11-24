package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.namespace.R
import android.widget.Button
import android.content.Intent
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class LogInActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val email = findViewById<android.widget.EditText>(R.id.email)
        val password = findViewById<android.widget.EditText>(R.id.password)
        val login = findViewById<Button>(R.id.logIn)
        val intent = Intent(this, SecondActivity::class.java)

        login.setOnClickListener {
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            val DatabaseReference: DatabaseReference = Firebase.database.reference.child("user").child(emailText)

            DatabaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val passwordDb = dataSnapshot.child("password").getValue(String::class.java)
                    val passwordDbText = passwordDb.toString()
                    Log.d(TAG, "Value1 is: $passwordDbText")
                    Log.d(TAG, "Value2 is: $passwordText")
                    if (passwordDb == null ) {
                        email.error = "Email is not recognized" }
                    else {
                    if (passwordText == passwordDbText) {
                        startActivity(intent)
                        }
                    else {
                        password.error = "Password is incorrect"
                    }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w(TAG, "Failed to read value.", error.toException())
                }
            })


        }
    }
}
