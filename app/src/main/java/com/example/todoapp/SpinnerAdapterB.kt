package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class SpinnerAdapterB (private val list: List<User>): BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView:View
        if (convertView == null){
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.spinner_item_view,parent, false)
        }else{
            itemView = convertView
        }

        itemView.findViewById<TextView>(R.id.txt_spinner_item).text = list[position].name
        if (list[position].image != -1)
            itemView.findViewById<ImageView>(R.id.image).setImageResource(list[position].image)

        return itemView
    }

}