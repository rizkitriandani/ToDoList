package com.belajar.todolist.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.belajar.todolist.R
import com.belajar.todolist.data.models.Priority
import com.belajar.todolist.data.models.ToDoData
import kotlinx.android.synthetic.main.row_layout.view.*
import java.util.zip.Inflater

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var dataList = emptyList<ToDoData>()

    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return  MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.itemView.tvToDoTitle.text = dataList[position].title
       holder.itemView.tvToDoDescription.text = dataList[position].description

        val priority = dataList[position].priority
        when(priority){
            Priority.HIGH -> holder.itemView.cvPriorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.priorityRed))
            Priority.MEDIUM -> holder.itemView.cvPriorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.priorityYellow))
            Priority.LOW -> holder.itemView.cvPriorityIndicator.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,R.color.priorityGreen))
        }
    }

    override fun getItemCount(): Int {
        return  dataList.size
    }

    fun setData(toDoData: List<ToDoData>){
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}