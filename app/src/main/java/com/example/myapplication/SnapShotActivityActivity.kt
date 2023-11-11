package com.example.namespace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivity
import com.example.namespace.R

class SnapShotActivityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.snap_shot_activity)

        // Use a constant for the delay to improve readability
        val delayMillis = 3000L

        Handler(Looper.getMainLooper()).postDelayed({
            // Use an explicit package name to avoid ambiguity
            val intent = Intent(this@SnapShotActivityActivity, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: Close the current activity after starting MainActivity
        }, delayMillis)
    }
}
