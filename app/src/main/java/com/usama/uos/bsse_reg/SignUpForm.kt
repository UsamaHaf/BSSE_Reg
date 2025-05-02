package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpForm : AppCompatActivity() {

   private lateinit var firebaseAuth: FirebaseAuth

   override fun onCreate(savedInstanceState: Bundle?) {

      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_sign_up_form)

      firebaseAuth = FirebaseAuth.getInstance()


      val btnSignUpForm = findViewById<Button>(R.id.btnSignup)
      val edtEmail = findViewById<EditText>(R.id.edtEmailAddress)
      val edtFirstName = findViewById<EditText>(R.id.edtFirstName)
      val edtLastName = findViewById<EditText>(R.id.edtLastName)
      val edtPassword = findViewById<EditText>(R.id.edtPassword)

      btnSignUpForm.setOnClickListener {

         if (edtEmail.text.toString().isEmpty()) {
            Toast.makeText(this@SignUpForm, "Please Enter EmailAddress", Toast.LENGTH_SHORT).show()

         } else if (edtFirstName.text.toString().isEmpty()) {
            Toast.makeText(this@SignUpForm, "Please Enter FirstName", Toast.LENGTH_SHORT).show()

         } else if (edtLastName.text.toString().isEmpty()) {
            Toast.makeText(this@SignUpForm, "Please Enter LastName", Toast.LENGTH_SHORT).show()

         } else if (edtPassword.text.toString().isEmpty()) {
            Toast.makeText(this@SignUpForm, "Please Enter Password", Toast.LENGTH_SHORT).show()

         } else {
            val strEmail = edtEmail.text.toString()
            val strPassword = edtPassword.text.toString()


            signUpFirebaseUser(edtEmail.text.toString(), edtPassword.text.toString())
            Log.e("UserEmail" , edtEmail.text.toString())
            Log.e("UserPassword" , edtPassword.text.toString())




         }
      }

   }


   private fun signUpFirebaseUser(strEmail: String, strPassword: String) {

      firebaseAuth.createUserWithEmailAndPassword(strEmail, strPassword).addOnCompleteListener { task ->

         if (task.isSuccessful) {
            Toast.makeText(this@SignUpForm, "SignIn Successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@SignUpForm, LoginForm::class.java))
         }else{

            Toast.makeText(this@SignUpForm, "SignIn Failed:- ${task.exception}", Toast.LENGTH_SHORT).show()

            Log.e("FailedFirebase" , task.exception.toString())

            startActivity(Intent(this@SignUpForm, LoginForm::class.java))
         }


      }


   }


}