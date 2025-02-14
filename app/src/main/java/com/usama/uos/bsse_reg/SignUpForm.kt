package com.usama.uos.bsse_reg

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpForm : AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_sign_up_form)

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
            Toast.makeText(this@SignUpForm, "Please Enter Password", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@SignUpForm, LoginForm::class.java))

         }
      }

   }


}