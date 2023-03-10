package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todoapp.databinding.ActivityPropertyyBinding

class Propertyy : AppCompatActivity() {
    private lateinit var binding: ActivityPropertyyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPraferences.init(this)
        val name = intent.getStringExtra("name")
        val planArray = MySharedPraferences.obektString
        var plan1 = ToDoPlan()
        var index = -1

        for (plan in planArray) {
            if (plan.name == name) {
                plan1 = plan
                index = planArray.indexOf(plan)
                binding.txtNamePlan.text = plan.name
                binding.txtDescription.text = plan.description
                binding.txtCreateData.text = plan.createData
                binding.txtDedline.text = plan.dedline
                binding.txtDegree.text = plan.degree?.name
                binding.imgPlan.setImageResource(plan.degree!!.image)
                when (plan.level) {
                    "Open" -> binding.radOpen.isChecked = true
                    "Development" -> binding.radDevelopment.isChecked = true
                    "Uploading" -> binding.radUploading.isChecked = true
                    "Reject" -> binding.radReject.isChecked = true
                    "Close" -> binding.radClosed.isChecked = true
                }
                break
            }
        }
        binding.btnOk.setOnClickListener {
            var rad = ""
            if (binding.radOpen.isChecked) rad = "Open"
            if (binding.radDevelopment.isChecked) rad = "Development"
            if (binding.radUploading.isChecked) rad = "Uploading"
            if (binding.radReject.isChecked) rad = "Reject"
            if (binding.radClosed.isChecked) rad = "Close"


            plan1.level = rad
            MySharedPraferences.obektString = planArray
            Toast.makeText(this, "Update", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}