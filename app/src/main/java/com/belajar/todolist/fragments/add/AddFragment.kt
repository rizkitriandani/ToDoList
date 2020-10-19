package com.belajar.todolist.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.belajar.todolist.R
import com.belajar.todolist.data.ToDoViewModel
import com.belajar.todolist.data.models.Priority
import com.belajar.todolist.data.models.ToDoData
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment() {

    private val toDoViewModel:ToDoViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        val view =inflater.inflate(R.layout.fragment_add, container, false)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_add_task -> {
                inserDataToDb()
            }

        }
        return super.onOptionsItemSelected(item)
    }


    private fun inserDataToDb(){
        val title = etTaskTitle.text.toString()
        val priority = spinnerPriority.selectedItem.toString()
        val description = etDescription.text.toString()

        val validation = verifyDataFromUser(title,description)

        if(validation){
            // insert data to db

            val newData = ToDoData(
                0,
                title,
                parsePriority(priority),
                description
            )

            toDoViewModel.insertData(newData)
            Toast.makeText(context, "Data added!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else{
            Toast.makeText(context, "Please Don't let empty field.!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun verifyDataFromUser(title:String, description:String) : Boolean{
        return if(TextUtils.isEmpty(title) || TextUtils.isEmpty(description)){
            false
        }else !(title.isEmpty() || description.isEmpty())
    }

    private fun parsePriority(priority:String) : Priority {
        return when(priority){
            "High Prioriry" -> {Priority.HIGH}
            "Medium Priority" -> Priority.MEDIUM
            "Low Priority" -> Priority.LOW
            else -> Priority.LOW
        }
    }


}