package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


/**
 * A simple [Fragment] subclass.
 */
class ToDoListFragment : Fragment() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var viewAdapter: ToDoListAdapter
    private lateinit var viewManager: StaggeredGridLayoutManager
    private var listener: ToDoListAdapter.ItemClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_to_do_list, container, false)

        val toDoList = ArrayList<ToDo>()
        for (i in 1..100) {
            toDoList.add(
                ToDo(
                    "Do Homework" + i,
                    "22.09.2000",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." + i
                )
            )
        }
        myRecyclerView = rootView.findViewById(R.id.myRecyclerView)
        viewManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        myRecyclerView.layoutManager = viewManager

        listener = object : ToDoListAdapter.ItemClickListener {
            override fun itemClick(position: Int, item: ToDo?) {
                val fragment = DetailFragment(item)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.main_container, fragment)
                    ?.commit()
            }
        }
        viewAdapter = context?.let { ToDoListAdapter(toDoList, it,
            listener as ToDoListAdapter.ItemClickListener
        ) }!!
        myRecyclerView.adapter = viewAdapter

        return rootView

    }
}
