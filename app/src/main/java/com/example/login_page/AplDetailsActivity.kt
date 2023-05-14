package com.example.login_page

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.FirebaseDatabase

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

        btnUpdate.setOnClickListener {
            openUpdateDialog(
                intent.getStringExtra("aplId").toString(),
                intent.getStringExtra("aplName").toString()
            )
        }
        btnDelete.setOnClickListener {
            deleteRecord(
                intent.getStringExtra("aplId").toString()
            )
        }
    }

    private fun deleteRecord(
        id:String){
        val dbRef = FirebaseDatabase.getInstance().getReference("Applications").child(id)
        val mTask = dbRef.removeValue()

        mTask.addOnSuccessListener {
            Toast.makeText(this,"Application deleted", Toast.LENGTH_LONG).show()


            val intent = Intent(this,MyApplications::class.java)
            finish()
            startActivity(intent)
        }.addOnFailureListener{error ->
            Toast.makeText(this,"Deleting Err ${error.message}",Toast.LENGTH_LONG).show()

        }
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
    private fun openUpdateDialog(
        aplId: String,
        aplName:String
    )
    {
    val mDialog = AlertDialog.Builder(this)
    val inflater = layoutInflater
    val mDialogView = inflater.inflate(R.layout.update_apl_dialog,null)
        mDialog.setView(mDialogView)
        val etAplName = mDialogView.findViewById<EditText>(R.id.etApluName)
        val etAplAddress = mDialogView.findViewById<EditText>(R.id.etApluAddress)
        val etAplEmail = mDialogView.findViewById<EditText>(R.id.etApluEmail)
        val etAplPhone = mDialogView.findViewById<EditText>(R.id.etApluPhone)
        val etAplSalary = mDialogView.findViewById<EditText>(R.id.etApluSalary)
        val etAplGender = mDialogView.findViewById<EditText>(R.id.etApluGender)
        val etAplTime = mDialogView.findViewById<EditText>(R.id.etApluTime)
        val etAplPosition = mDialogView.findViewById<EditText>(R.id.etApluPosition)
        val etAplStDate = mDialogView.findViewById<EditText>(R.id.etApluStDate)
        val etAplEdDate = mDialogView.findViewById<EditText>(R.id.etApluEdDate)
        val etAplGraduate = mDialogView.findViewById<EditText>(R.id.etApluGraduate)
        val etAplDegree = mDialogView.findViewById<EditText>(R.id.etApluDegree)
        val etAplUniversity = mDialogView.findViewById<EditText>(R.id.etApluUni)
        val etAplDiploma = mDialogView.findViewById<EditText>(R.id.etApluDiploma)
        val etAplCollege = mDialogView.findViewById<EditText>(R.id.etApluCollege)



        val btnUpdateData = mDialogView.findViewById<Button>(R.id.btnUpdateData)

        etAplName.setText(intent.getStringExtra("aplName").toString())
        etAplAddress.setText(intent.getStringExtra("aplAddress").toString())
        etAplEmail.setText(intent.getStringExtra("aplEmail").toString())
        etAplPhone.setText(intent.getStringExtra("aplPhone").toString())
        etAplSalary.setText(intent.getStringExtra("aplSalary").toString())
        etAplGender.setText(intent.getStringExtra("aplGender").toString())
        etAplTime.setText(intent.getStringExtra("aplTime").toString())
        etAplPosition.setText(intent.getStringExtra("aplPosition").toString())
        etAplStDate.setText(intent.getStringExtra("aplStDate").toString())
        etAplEdDate.setText(intent.getStringExtra("aplEdDate").toString())
        etAplGraduate.setText(intent.getStringExtra("aplGraduate").toString())
        etAplDegree.setText(intent.getStringExtra("aplDegree").toString())
        etAplUniversity.setText(intent.getStringExtra("aplUniversity").toString())
        etAplDiploma.setText(intent.getStringExtra("aplDiploma").toString())
        etAplCollege.setText(intent.getStringExtra("aplCollege").toString())

        mDialog.setTitle("Updating $aplName Record")

        val alertDialog = mDialog.create()
        alertDialog.show()
        btnUpdateData.setOnClickListener {
            updateAplData(
                aplId,
                etAplName.text.toString(),
                etAplAddress.text.toString(),
                etAplEmail.text.toString(),
                etAplPhone.text.toString(),
                etAplSalary.text.toString(),
                etAplGender.text.toString(),
                etAplTime.text.toString(),
                etAplPosition.text.toString(),
                etAplStDate.text.toString(),
                etAplEdDate.text.toString(),
                etAplGraduate.text.toString(),
                etAplDegree.text.toString(),
                etAplUniversity.text.toString(),
                etAplDiploma.text.toString(),
                etAplCollege.text.toString()
            )
            tvAplName.text = etAplName.text.toString()
            tvAplAddress.text = etAplAddress.text.toString()
            tvAplEmail.text = etAplEmail.text.toString()
            tvAplPhone.text = etAplPhone.text.toString()
            tvAplSalary.text = etAplSalary.text.toString()
            tvAplGender.text = etAplGender.text.toString()
            tvAplTime.text = etAplTime.text.toString()
            tvAplPosition.text = etAplPosition.text.toString()
            tvAplStDate.text = etAplStDate.text.toString()
            tvAplEdDate.text = etAplEdDate.text.toString()
            tvAplGraduate.text = etAplGraduate.text.toString()
            tvAplDegree.text = etAplDegree.text.toString()
            tvAplUniversity.text = etAplUniversity.text.toString()
            tvAplDiploma.text = etAplDiploma.text.toString()
            tvAplCollege.text = etAplCollege.text.toString()

            alertDialog.dismiss()
        }

        Toast.makeText(applicationContext,"Application Data Updated Successfully",Toast.LENGTH_LONG).show()

    }

    private fun updateAplData(
        id: String,
        name: String,
        address: String,
        email: String,
        phone: String,
        salary: String,
        gender: String,
        time: String,
        position: String,
        stDate: String,
        edDate: String,
        graduate: String,
        degree: String,
        university: String,
        diploma: String,
        college: String,

    ){
        val dbRef = FirebaseDatabase.getInstance().getReference("Applications").child(id)
        val aplInfo = ApplicationModel(id,name,address,email,phone,salary,gender,time,position,stDate,edDate,graduate,degree,university,diploma,college)
        dbRef.setValue(aplInfo)
    }
}