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
import com.belajar.todolist.fragments.SharedViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    //delegate
    private val toDoViewModel:ToDoViewModel by viewModels()
    val sharedViewModel:SharedViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        val view =inflater.inflate(R.layout.fragment_add, container, false)

        view.spinnerPriority.onItemSelectedListener = sharedViewModel.listener

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

        //1. get dulu nilai dari inputan user.
        val title = etTaskTitle.text.toString()
        val priority = spinnerPriority.selectedItem.toString()
        val description = etDescription.text.toString()

        //2. validasi inputan dari user (untuk ngecek apakah semua field sudah diisi)
        val validation = sharedViewModel.verifyDataFromUser(title,description)

        //3. bikin kondisional untuk ngecek balikan nilai dari method validasi inputan tadi
        if(validation){
            // kalo valid maka insert data to db. Idnya dibuat 0 aja karena ntar diatur sendiri sm db nya.

            val newData = ToDoData(
                0,
                title,
                sharedViewModel.parsePriority(priority),
                description
            )

            //4. panggil method insert data, sebelumnya jangan lupa bikin instansiasi objek viewmodelnya
            toDoViewModel.insertData(newData)
            Toast.makeText(context, "Data added!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        }else
                //JIka tidak valide munculkan pesan error
            Toast.makeText(context, "Please Don't let empty field.!", Toast.LENGTH_SHORT).show()
        }




    }

