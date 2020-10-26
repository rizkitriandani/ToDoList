package com.belajar.todolist.fragments

import android.app.Application
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import com.belajar.todolist.data.models.Priority

class SharedViewModel(application:Application) : AndroidViewModel(application) {

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