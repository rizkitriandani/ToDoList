package com.belajar.todolist.fragments

import android.app.Application
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import com.belajar.todolist.R
import com.belajar.todolist.data.models.Priority

class SharedViewModel(application:Application) : AndroidViewModel(application) {

    val listener: AdapterView.OnItemSelectedListener = object :
        AdapterView.OnItemSelectedListener{
        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long) {

            when(position){
                0 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.priorityRed))}
                1 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.priorityYellow))}
                2 -> {(parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.priorityGreen))}
            }

        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(application, R.color.colorAccentBlack))
        }


    }


    //method untuk ngecek inputan dari user
    fun verifyDataFromUser(title: String, description: String): Boolean {
        return if (TextUtils.isEmpty(title) || TextUtils.isEmpty(description)) {
            false
        } else !(title.isEmpty() || description.isEmpty())
    }

    //method untuk convert value string dari spinner inputan ke dalam bentuk objek priority
    fun parsePriority(priority: String): Priority {
        return when (priority) {
            "High Prioriry" -> {
                Priority.HIGH
            }
            "Medium Priority" -> Priority.MEDIUM
            "Low Priority" -> Priority.LOW
            else -> Priority.LOW
        }
    }
}