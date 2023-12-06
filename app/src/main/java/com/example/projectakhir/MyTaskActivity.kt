package com.example.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectakhir.databinding.ActivityMyTaskBinding
import com.example.projectakhir.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import oop.Task
import oop.myTaskAdapter

class MyTaskActivity : AppCompatActivity() {


    lateinit var binding : ActivityMyTaskBinding
    lateinit var auth: FirebaseAuth
    var db = Firebase.firestore
    private lateinit var taskList : ArrayList<Task>
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMyTaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBackMytask.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnToHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnToMyTask.setOnClickListener {
            val intent = Intent(this, MyTaskActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSendTask.setOnClickListener {
            val intent = Intent(this, SendTaskActivity::class.java)
            startActivity(intent)
        }

        binding.btnToLogOut.setOnClickListener {
            val intent = Intent(this, FirstPage::class.java)
            startActivity(intent)
        }
    }
}