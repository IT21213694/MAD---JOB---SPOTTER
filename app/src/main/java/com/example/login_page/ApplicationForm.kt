package com.example.login_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ApplicationForm : AppCompatActivity() {


    private lateinit var apname:EditText
    private lateinit var apaddress:EditText
    private lateinit var apemail:EditText
    private lateinit var apphone :EditText
    private lateinit var apSalary:EditText
    private lateinit var apGender:EditText
    private lateinit var apTime:EditText
    private lateinit var apPosition:EditText
    private lateinit var apStDate:EditText
    private lateinit var apEdDate:EditText
    private lateinit var apGraduate:EditText
    private lateinit var apDegree:EditText
    private lateinit var apUniversity:EditText
    private lateinit var apDiploma:EditText
    private lateinit var apCollege:EditText
    private lateinit var applybtn:Button
    private lateinit var btnFetchData:Button

    private lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application_form)

         applybtn = findViewById(R.id.apply_application_btn)
        btnFetchData = findViewById(R.id.fetch_application_btn)

        apname = findViewById(R.id.etAplName)
        apaddress = findViewById(R.id.etAplAdress)
        apemail = findViewById(R.id.etAplEmail)
        apphone = findViewById(R.id.etAplPhone)
        apSalary = findViewById(R.id.etAplSalary)
        apGender = findViewById(R.id.etAplGender)
        apTime = findViewById(R.id.etAplTime)
        apPosition = findViewById(R.id.etAplPosition)
        apStDate = findViewById(R.id.etAplStDate)
        apEdDate = findViewById(R.id.etAplEdDate)
        apGraduate = findViewById(R.id.etAplGraduate)
        apDegree = findViewById(R.id.etAplDegree)
        apUniversity = findViewById(R.id.etAplUni)
        apDiploma = findViewById(R.id.etAplDip)
        apCollege = findViewById(R.id.etAplCollege)

        dbRef = FirebaseDatabase.getInstance().getReference("Applications")

        applybtn.setOnClickListener {
            saveApplicationData()
        }
        btnFetchData.setOnClickListener {
            val intent = Intent(this,MyApplications::class.java)
            startActivity(intent)
        }
    }

    private fun saveApplicationData() {
        val aplName = apname.text.toString()
        val aplAddress = apaddress.text.toString()
        val aplEmail = apemail.text.toString()
        val aplPhone = apphone.text.toString()
        val aplSalary = apSalary.text.toString()
        val aplGender = apGender.text.toString()
        val aplTime = apTime.text.toString()
        val aplPosition = apPosition.text.toString()
        val aplStDate = apStDate.text.toString()
        val aplEdDate = apEdDate.text.toString()
        val aplGraduate = apGraduate.text.toString()
        val aplDegree = apDegree.text.toString()
        val aplUniversity = apUniversity.text.toString()
        val aplDiploma = apDiploma.text.toString()
        val aplCollege = apCollege.text.toString()

        if(aplName.isEmpty()){
            apname.error="Please fill the data"
        }
        if(aplAddress.isEmpty()){
            apaddress.error="Please fill the data"
        }
        if(aplEmail.isEmpty()){
            apemail.error="Please fill the data"
        }
        if(aplPhone.isEmpty()){
            apphone.error="Please fill the data"
        }
        if(aplSalary.isEmpty()){
            apSalary.error="Please fill the data"
        }

        val aplId = dbRef.push().key!!
        val application = ApplicationModel(aplId,aplName,aplAddress,aplEmail,aplPhone,aplSalary,aplGender,aplTime,aplPosition,aplStDate,aplEdDate,aplGraduate, aplDegree, aplUniversity, aplDiploma,aplCollege)

        dbRef.child(aplId).setValue(application)
            .addOnCompleteListener{
                Toast.makeText(this,"Applied Application Successfully",Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                err->Toast.makeText(this,"Error ${err.message}",Toast.LENGTH_LONG).show()
            }
    }


}