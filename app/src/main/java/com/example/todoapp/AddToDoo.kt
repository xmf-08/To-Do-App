package com.example.todoapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityAddToDooBinding
import java.util.*
import kotlin.collections.ArrayList

class AddToDoo : AppCompatActivity() {
    lateinit var binding: ActivityAddToDooBinding
    lateinit var userArray: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddToDooBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()

        MySharedPraferences.init(this)

        val spinnerAdapter = SpinnerAdapterB(userArray)
        binding.edtToDoSpinner.adapter = spinnerAdapter

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val c1 = Calendar.getInstance()
        val year1 = c1.get(Calendar.YEAR)
        val month1= c1.get(Calendar.MONTH)
        val day1= c1.get(Calendar.DAY_OF_MONTH)

        binding.edtCreateDate.setOnClickListener {
            val d = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, mYear, mMonth, mDay ->
                binding.edtCreateDate.setText("$mDay.$mMonth.$mYear")
            },year,month,day)
            d.show()
        }
        binding.edtDedline.setOnClickListener {
            val d = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, mYear, mMonth, mDay ->
                binding.edtDedline.setText("$mDay.$mMonth.$mYear")
            },year1,month1,day1)
            d.show()
        }

        binding.btnSave.setOnClickListener {
            val toDoName = binding.edtName.text.toString().trim()
            val toDoDescription = binding.edtDescription.text.toString().trim()
            val toDoCreateData = binding.edtCreateDate.text.toString().trim()
            val toDoDedline = binding.edtDedline.text.toString().trim()

            val degree = userArray[binding.edtToDoSpinner.selectedItemPosition]

            if (toDoName.isNotEmpty() && toDoDescription.isNotEmpty() && toDoCreateData.isNotEmpty() && toDoDedline.isNotEmpty()) {
                val myList = MySharedPraferences.obektString
                myList.add(
                    ToDoPlan(
                        toDoName,
                        toDoDescription,
                        degree,
                        toDoCreateData,
                        toDoDedline,
                        "Open"
                    )
                )
                MySharedPraferences.obektString = myList
                Toast.makeText(this, "Saved successful!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "List empty yet!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadData() {
        userArray = ArrayList()
        userArray.add(User(-1, "To do degree"))
        userArray.add(User(R.drawable.ic_flag_high, "High"))
        userArray.add(User(R.drawable.ic_flag_urgent, "Urgent"))
        userArray.add(User(R.drawable.icflag_normal, "Normal"))
        userArray.add(User(R.drawable.ic_flag_low, "Low"))
    }
}