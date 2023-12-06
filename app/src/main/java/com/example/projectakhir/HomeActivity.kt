package com.example.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AbsoluteLayout
import android.widget.Button
import android.widget.LinearLayout
import com.example.projectakhir.databinding.ActivityHomeBinding
import com.example.projectakhir.databinding.ActivityLoginBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvEmail.apply {
            text = intent.getStringExtra("email")
        }
        binding.tvEmail.setText(intent.getStringExtra("email"))
        binding.btnToAbout.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                    this@HomeActivity, R.style.ButtomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.activity_about,
                findViewById(R.id.bottomSheet) as AbsoluteLayout?
            )

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        binding.tvToAbout.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                this@HomeActivity, R.style.ButtomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.activity_about,
                findViewById(R.id.bottomSheet) as AbsoluteLayout?
            )

            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }

        binding.btnToMyTask.setOnClickListener {
            val intent = Intent(this, MyTaskActivity::class.java)
            startActivity(intent)
        }

        binding.tvToMyTask.setOnClickListener {
            val intent = Intent(this, MyTaskActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSendTask.setOnClickListener {
            val intent = Intent(this, SendTaskActivity::class.java).also {
                it.putExtra("email", binding.tvEmail.text.toString())
            }
            startActivity(intent)
        }

        binding.tvToSendTask.setOnClickListener {
            val intent = Intent(this, SendTaskActivity::class.java).also {
                it.putExtra("email", binding.tvEmail.text.toString())
            }
            startActivity(intent)
        }

        binding.btnToLogOut.setOnClickListener {
            val intent = Intent(this, FirstPage::class.java)
            startActivity(intent)
        }

        binding.tvToLogout.setOnClickListener {
            val intent = Intent(this, FirstPage::class.java)
            startActivity(intent)
        }
    }
}