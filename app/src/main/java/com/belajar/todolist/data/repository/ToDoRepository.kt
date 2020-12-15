package com.belajar.todolist.data.repository

import androidx.lifecycle.LiveData
import com.belajar.todolist.data.ToDoDao
import com.belajar.todolist.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()

    suspend fun insertData(toDoData: ToDoData){
        toDoDao.insertData(toDoData)
    }

}