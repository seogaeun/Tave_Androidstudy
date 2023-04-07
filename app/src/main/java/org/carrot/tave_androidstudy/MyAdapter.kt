package org.carrot.tave_androidstudy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context,
                val list: List<ToDoEntity>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_plan,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val todo : ToDoEntity = list[position]

        holder.todo.text=todo.todo
        holder.root.setOnLongClickListener(object :View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                return true
            }
        })

    }



    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val todo = itemView.findViewById<TextView>(R.id.textview_todo)
        val root = itemView.findViewById<View>(R.id.root)


    }


}