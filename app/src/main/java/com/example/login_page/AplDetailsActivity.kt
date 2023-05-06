package com.example.login_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AplDetailsActivity : AppCompatActivity() {
    private lateinit var tvAplId: TextView
    private lateinit var tvAplName: TextView
    private lateinit var tvAplAddress: TextView
    private lateinit var tvAplEmail: TextView
    private lateinit var tvAplPhone: TextView
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apl_details)
        initView()
        setValuesToView()
    }

    private fun initView() {
        tvAplId = findViewById(R.id.tvAplId)
        tvAplName = findViewById(R.id.tvAplName)
        tvAplAddress = findViewById(R.id.tvAplAddress)
        tvAplEmail = findViewById(R.id.tvAplEmail)
        tvAplPhone = findViewById(R.id.tvAplPhone)

        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }
    private fun setValuesToView(){
        tvAplId.text = intent.getStringExtra("aplId")
        tvAplName.text = intent.getStringExtra("aplName")
        tvAplAddress.text = intent.getStringExtra("aplAddress")
        tvAplEmail.text = intent.getStringExtra("aplEmail")
        tvAplPhone.text = intent.getStringExtra("aplPhone")
    }
}