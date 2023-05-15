package com.example.login_page

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.login_page.databinding.ActivityRegistrationPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

@Suppress("DEPRECATION")
class RegistrationPage : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationPageBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationPageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        binding.button5.setOnClickListener {
            validateData()
        }

    }
    private var name =""
    private var email =""
    private var password =""
    private var address =""
    private var date_of_birth =""
    private var age =""
    private var phone =""
    private var gender =""

    private fun validateData() {
        name = binding.editTextTextPersonName1.text.toString().trim()
        email= binding.editTextEmailAddress2.text.toString().trim()
        password = binding.editTextPassword3.text.toString().trim()
        address = binding.editTextTextPersonName2.text.toString().trim()
        date_of_birth = binding.editTextDate2.text.toString().trim()
        age = binding.editTextNumber.text.toString().trim()
        phone = binding.editTextPhone.text.toString().trim()
        gender = binding.radioButton.text.toString().trim()
        gender = binding.radioButton2.text.toString().trim()
        val cPassword = binding.cPassword.text.toString().trim()

        if (name.isEmpty()){
            Toast.makeText(this,"Enter your name...", Toast.LENGTH_SHORT).show()
        }
        else if (phone.isEmpty()){
            Toast.makeText(this,"Enter your phone number...", Toast.LENGTH_SHORT).show()
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this,"Invalid Email Pattern...", Toast.LENGTH_SHORT).show()
        }

        else if (password.isEmpty()){
            Toast.makeText(this,"Enter password...", Toast.LENGTH_SHORT).show()
        }
        else if (cPassword.isEmpty()){
            Toast.makeText(this,"Confirm password...", Toast.LENGTH_SHORT).show()
        }
      else if ( password != cPassword){
            Toast.makeText(this,"Password doesn't match...", Toast.LENGTH_SHORT).show()
      }
      else{
         createUserAccount()
      }


    }

    private fun createUserAccount() {
        progressDialog.setMessage("Creating Account....")
        progressDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                updateUserInfo()
            }
            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(this,"Failed creating account due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateUserInfo() {
       progressDialog.setMessage("Saving user info...")

        val timestamp = System.currentTimeMillis()

       val uid = firebaseAuth.uid
        val hashMap: HashMap<String, Any?> = HashMap()
        hashMap["uid"] = uid
        hashMap["email"] = email
        hashMap["name"] = name
        hashMap["address"] = address
        hashMap["date of birth"] = date_of_birth
        hashMap["age"] = age
        hashMap["phone"] = phone
        hashMap["gender"] = gender
        hashMap["profileImage"] = ""
        hashMap["userType"] = "user"
        hashMap["timestamp"] = timestamp

        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(this,"Account created...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@RegistrationPage, HomePage::class.java))
                finish()

            }
            .addOnFailureListener {e->
                progressDialog.dismiss()
                Toast.makeText(this,"Failed saving user info due to ${e.message}", Toast.LENGTH_SHORT).show()
            }

    }

}