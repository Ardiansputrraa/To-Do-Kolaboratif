package com.example.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectakhir.databinding.ActivityMyTaskBinding
import com.example.projectakhir.databinding.ActivitySendTaskBinding

class SendTaskActivity : AppCompatActivity() {


    lateinit var binding : ActivitySendTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySendTaskBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBackSendtask.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnToAddTask.setOnClickListener {
            val email = intent.getStringExtra("email")
            val intent = Intent(this, AddTaskActivity::class.java).also {
                it.putExtra("email", email)
            }
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