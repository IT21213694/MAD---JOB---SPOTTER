package com.example.login_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivity()
        setContentView(R.layout.activity_main)

    }


    fun redirectRegistrationPage(view: View) {
        val intent = Intent(this, RegistrationPage::class.java)
        startActivity(intent)
    }
    fun redirectSignupEmp(view: View) {
        val intent = Intent(this, SignupEmp::class.java)
        startActivity(intent)
    }


}