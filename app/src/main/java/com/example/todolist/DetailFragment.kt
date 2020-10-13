package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment(val item: ToDo?) : Fragment() {
    private lateinit var title: TextView
    private lateinit var data: TextView
    private lateinit var description: TextView
    private lateinit var back: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_detail, container, false)
        title = rootview.findViewById(R.id.title)
        data = rootview.findViewById(R.id.data)
        description = rootview.findViewById(R.id.description)
        title.text = item?.title
        data.text = item?.data
        description.text = item?.description
        return rootview
    }

}
