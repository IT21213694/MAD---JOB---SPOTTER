package com.example.login_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.login_page.databinding.ActivityMainBinding

class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)
    }

    fun redirectLogin(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



}