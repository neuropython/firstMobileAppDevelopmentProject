package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.namespace.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RecycleViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var newArray: ArrayList<Games_data>
    lateinit var numbers : Array<Int>
    lateinit var email : String
    lateinit var win : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        


        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        newArray = arrayListOf<Games_data>()
        val email = "example@email.com" // Replace with actual email
        val numbers = arrayOf(1, 2, 3, 4, 5) // Replace with actual numbers
        val win = "Win Status" // Replace with actual win status
        val game = Games_data(email, numbers, win)
        newArray.add(game)
        recyclerView.adapter = MyAdapter(newArray)



        val DatabaseReference: DatabaseReference = Firebase.database.reference.child("user")


//        getGamesData()
    }

    private fun getGamesData() {
        val email = "example@email.com" // Replace with actual email
        val numbers = arrayOf(1, 2, 3, 4, 5) // Replace with actual numbers
        val win = "Win Status" // Replace with actual win status
        val game = Games_data(email, numbers, win)
        newArray.add(game)
        recyclerView.adapter = MyAdapter(newArray)
    }
}
