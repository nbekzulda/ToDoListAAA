package com.example.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoListAdapter(
    val todolist: ArrayList<ToDo>,
    val context: Context,
    val listener: ItemClickListener
) :
    RecyclerView.Adapter<ToDoListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo = todolist.get(position)
        holder.titleText.text = todo.title
        holder.statusText.text = todo.status
        holder.categoryText.text = todo.category
        holder.itemView.setOnClickListener {
            listener.itemClick(
                position,
                todo
            )
        }
    }

    override fun getItemCount(): Int {
        return todolist.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleText: TextView = view.findViewById(R.id.title)
        var statusText: TextView = view.findViewById(R.id.status)
        var categoryText: TextView = view.findViewById(R.id.category)

    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: ToDo?)
    }
}