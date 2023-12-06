package com.example.projectakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.projectakhir.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern
import oop.Users
import java.text.SimpleDateFormat
import java.util.*

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var auth: FirebaseAuth
    lateinit var database : DatabaseReference
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnToLogin.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener{
            val fullname = binding.editTextTextPersonName.text.toString()
            val email = binding.editEmailRegister.text.toString()
            val password = binding.editPasswordRegister.text.toString()
            val user = Users(fullname, email, password)

            if (fullname.isEmpty()) {
                binding.editTextTextPersonName.error = "Fullname Harus Diisi!"
                binding.editTextTextPersonName.requestFocus()
                return@setOnClickListener
            }
            //Validasi Email
            if(email.isEmpty()){
                binding.editEmailRegister.error = "Email Harus Diisi!"
                binding.editEmailRegister.requestFocus()
                return@setOnClickListener
            }

            //Validasi Email tidak sesuai
            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editEmailRegister.error = "Email Tidak Valid"
                binding.editEmailRegister.requestFocus()
                return@setOnClickListener
            }

            //Validasi Password
            if(password.isEmpty()) {
                binding.editPasswordRegister.error = "Password Harus Diisi!"
                binding.editPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            //Validasi panjang password
            if(password.length < 6){
                binding.editPasswordRegister.error = "Password minimal 6 karakter!"
                binding.editPasswordRegister.requestFocus()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                    if(it.isSuccessful){
                        val intent = Intent(this, RegisterActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "${it.exception?.message}",Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }

    private fun RegisterFirebase(email: String, password: String, user : Users) {

    }
}