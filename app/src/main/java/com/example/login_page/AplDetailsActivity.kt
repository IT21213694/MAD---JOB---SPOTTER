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
    private lateinit var tvAplSalary: TextView
    private lateinit var tvAplGender: TextView
    private lateinit var tvAplTime: TextView
    private lateinit var tvAplPosition: TextView
    private lateinit var tvAplStDate: TextView
    private lateinit var tvAplEdDate: TextView
    private lateinit var tvAplGraduate: TextView
    private lateinit var tvAplDegree: TextView
    private lateinit var tvAplUniversity: TextView
    private lateinit var tvAplDiploma: TextView
    private lateinit var tvAplCollege: TextView

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
        tvAplSalary = findViewById(R.id.tvAplSalary)
        tvAplGender = findViewById(R.id.tvAplGender)
        tvAplTime = findViewById(R.id.tvAplTime)
        tvAplPosition = findViewById(R.id.tvAplPosition)
        tvAplStDate = findViewById(R.id.tvAplStDate)
        tvAplEdDate = findViewById(R.id.tvAplEdDate)
        tvAplGraduate = findViewById(R.id.tvAplGraduate)
        tvAplDegree = findViewById(R.id.tvAplDegree)
        tvAplUniversity = findViewById(R.id.tvAplUniversity)
        tvAplDiploma= findViewById(R.id.tvAplDiploma)
        tvAplCollege= findViewById(R.id.tvAplCollege)

        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
    }
    private fun setValuesToView(){
        tvAplId.text = intent.getStringExtra("aplId")
        tvAplName.text = intent.getStringExtra("aplName")
        tvAplAddress.text = intent.getStringExtra("aplAddress")
        tvAplEmail.text = intent.getStringExtra("aplEmail")
        tvAplPhone.text = intent.getStringExtra("aplPhone")
        tvAplSalary.text = intent.getStringExtra("aplSalary")
        tvAplGender.text = intent.getStringExtra("aplGender")
        tvAplTime.text = intent.getStringExtra("aplTime")
        tvAplPosition.text = intent.getStringExtra("aplPosition")
        tvAplStDate.text = intent.getStringExtra("aplStDate")
        tvAplEdDate.text = intent.getStringExtra("aplEdDate")
        tvAplGraduate.text = intent.getStringExtra("aplGraduate")
        tvAplDegree.text = intent.getStringExtra("aplDegree")
        tvAplUniversity.text = intent.getStringExtra("aplUniversity")
        tvAplDiploma.text = intent.getStringExtra("aplDiploma")
        tvAplCollege.text = intent.getStringExtra("aplCollege")


    }
}