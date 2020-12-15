package com.belajar.todolist.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


//THIS IS THE ENTITY CLASS
@Entity(tableName = "todo_table")
data class ToDoData (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: Priority,
    var description: String
)