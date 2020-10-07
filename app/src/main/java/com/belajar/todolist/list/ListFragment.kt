package com.belajar.todolist.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.belajar.todolist.R
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false);

        view.fabAddTask.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment);
        }

        setHasOptionsMenu(true)

        return view;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
      inflater.inflate(R.menu.list_fragment_menu, menu)
    }

}