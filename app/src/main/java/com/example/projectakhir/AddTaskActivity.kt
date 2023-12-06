package com.example.projectakhir

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectakhir.databinding.ActivityAddTaskBinding
import com.example.projectakhir.databinding.ActivitySendTaskBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import oop.AddTask
import oop.Task
import oop.taskAdapter
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

class AddTaskActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddTaskBinding
    lateinit var auth: FirebaseAuth
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        val nameCreateTask = intent.getStringExtra("email").toString()
        System.out.println(nameCreateTask)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val myCalender = Calendar.getInstance()
        val dataPicker = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalender.set(Calendar.YEAR, year)
            myCalender.set(Calendar.MONTH, month)
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalender)
        }

        binding.btnToDatePicker.setOnClickListener{
            DatePickerDialog(this, dataPicker, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH),
            myCalender.get(Calendar.DAY_OF_MONTH)).show()
        }

        binding.btnToJam.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener {
                view, hourOfDay, minute ->
                binding.tvToJam.setText("$hourOfDay : ${minute}")
            }, startHour, startMinute, false).show()
        }

        binding.btnBackSendTask.setOnClickListener {
            val intent = Intent(this, SendTaskActivity::class.java)
            startActivity(intent)
        }

        val taskNewAdd = arrayListOf<AddTask>()
        binding.btnToNewTask.setOnClickListener{
            taskNewAdd.add(AddTask(binding.editInputTask.text.toString()))
            val adapter = taskAdapter(taskNewAdd)
            binding.rvAddTask.layoutManager = LinearLayoutManager(this@AddTaskActivity)
            binding.rvAddTask.adapter = adapter
            binding.editInputTask.text.clear()
        }

        binding.btnToDone.setOnClickListener{
            val namaPenerima = binding.editToNamaPenerima.text.toString()
            val titleTask = binding.editToTitleTask.text.toString()
            val deadlineTanggal = binding.tvToDatePicker.text.toString()
            val deadlineJam = binding.tvToJam.text.toString()
            val nameCreateTask = intent.getStringExtra("email").toString()
            val taskMap = hashMapOf(
                "namaPenerima" to namaPenerima,
                "titleTask" to titleTask,
                "deadlineTanggal" to deadlineTanggal,
                "deadLineJam" to deadlineJam,
                "nameCreateTask" to nameCreateTask,
                "Tugas" to taskNewAdd
            )
            val userCreate = nameCreateTask + " " + FirebaseAuth.getInstance().currentUser!!.uid
            db.collection("task").document(userCreate).set(taskMap).addOnSuccessListener {
                Toast.makeText(this, "task added successfully", Toast.LENGTH_SHORT).show()
            }

            val userAssigned = namaPenerima + " " + FirebaseAuth.getInstance().currentUser!!.uid
            db.collection("task").document(userAssigned).set(taskMap).addOnSuccessListener {
                Toast.makeText(this, "task added successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateLable(myCalender: Calendar) {
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.tvToDatePicker.setText(sdf.format(myCalender.time))
    }
}