package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpendAdapter(var titleList: List<String>, var map: HashMap<String, ArrayList<String>>) : BaseExpandableListAdapter(){
    override fun getGroup(groupPosition: Int): String = titleList[groupPosition]

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean =true

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var groupItemView:View
        if (convertView == null){
            groupItemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_group, parent, false)
        }else{
            groupItemView = convertView
        }
        groupItemView.findViewById<TextView>(R.id.txt_name).text = titleList[groupPosition]
        return groupItemView
    }

    override fun getChildrenCount(groupPosition: Int): Int = map[titleList[groupPosition]]!!.size

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]!!.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var childItemView:View
        if (convertView == null){
            childItemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_child, parent, false)
        }else{
            childItemView = convertView
        }

        val list = map[titleList[groupPosition]]
        val childItem = list?.get(childPosition)
//        childItemView.txt_child.text = childItem

        childItemView.findViewById<TextView>(R.id.txt_child).text = childItem
        return childItemView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun getGroupCount(): Int = titleList.size

}