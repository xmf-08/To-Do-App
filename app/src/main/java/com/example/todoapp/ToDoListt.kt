package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.todoapp.databinding.ActivityToDoListtBinding

class ToDoListt : AppCompatActivity() {
    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var titleList: ArrayList<String>
    lateinit var openArray: ArrayList<String>
    lateinit var developmentArray: ArrayList<String>
    lateinit var uploadingArray: ArrayList<String>
    lateinit var rejectArray: ArrayList<String>
    lateinit var closedArray: ArrayList<String>
    private lateinit var binding: ActivityToDoListtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToDoListtBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPraferences.init(this)
        fromCatchToArray()

        binding.expendMenu.setOnChildClickListener { expandableListView, view, i, i2, l ->
            val intent = Intent(this, Propertyy::class.java)
            intent.putExtra("name", map[titleList[i]]?.get(i2))
            startActivity(intent)
            true
        }
    }

    private fun fromCatchToArray() {
        map = HashMap()
        titleList = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Close")

        openArray = ArrayList()
        developmentArray = ArrayList()
        uploadingArray = ArrayList()
        rejectArray = ArrayList()
        closedArray = ArrayList()

        var planArray = ArrayList<ToDoPlan>()
        planArray = MySharedPraferences.obektString
        var nameArray = ArrayList<ToDoPlan>()

        for (toDoPlan in planArray) {
            if (toDoPlan.level == "Open") {
                openArray.add(toDoPlan.name)
            }
            if (toDoPlan.level == "Development") {
                developmentArray.add(toDoPlan.name)
            }
            if (toDoPlan.level == "Uploading") {
                uploadingArray.add(toDoPlan.name)
            }
            if (toDoPlan.level == "Reject") {
                rejectArray.add(toDoPlan.name)
            }
            if (toDoPlan.level == "Close") {
                closedArray.add(toDoPlan.name)
            }
        }
        map[titleList[0]] = openArray
        map[titleList[1]] = developmentArray
        map[titleList[2]] = uploadingArray
        map[titleList[3]] = rejectArray
        map[titleList[4]] = closedArray
    }

    override fun onStart() {
        super.onStart()
        MySharedPraferences.init(this)
        fromCatchToArray()
        Log.i("information", "OnStarMethod")
        val spinnnerAdapterB = ExpendAdapter(titleList, map)
        binding.expendMenu.setAdapter(spinnnerAdapterB)
    }
}