package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.namespace.R

class MyAdapter(private val myDataset: ArrayList<Games_data>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.games_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myDataset[position]
        holder.textView1.text = currentItem.email
        holder.textView2.text = currentItem.numbers.toString()
        holder.textView3.text = currentItem.win
    }

    override fun getItemCount() = myDataset.size

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.findViewById<TextView>(R.id.currentGame)
        val textView2: TextView = itemView.findViewById<TextView>(R.id.numView)
        val textView3: TextView = itemView.findViewById<TextView>(R.id.win)
    }
}