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
    private lateinit var apphone :EditText
    private lateinit var apemail:EditText
    private lateinit var apSalary:EditText
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

        if(aplName.isEmpty()||aplAddress.isEmpty()||aplEmail.isEmpty()||aplPhone.isEmpty()){
            apname.error="Please fill the data"
        }

        val aplId = dbRef.push().key!!
        val application = ApplicationModel(aplId,aplName,aplAddress,aplEmail,aplPhone)

        dbRef.child(aplId).setValue(application)
            .addOnCompleteListener{
                Toast.makeText(this,"Applied Application Successfully",Toast.LENGTH_LONG).show()
            }.addOnFailureListener{
                err->Toast.makeText(this,"Error ${err.message}",Toast.LENGTH_LONG).show()
            }
    }


}