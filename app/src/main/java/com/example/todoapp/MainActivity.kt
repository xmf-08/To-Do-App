package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddToDo.setOnClickListener {
            val intent = Intent(this, AddToDoo::class.java)
            startActivity(intent)
        }
        binding.btnToDoList.setOnClickListener {
            val intent = Intent(this, ToDoListt::class.java)
            startActivity(intent)
        }
    }
}