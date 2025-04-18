package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.usama.uos.bsse_reg.SharedPref.MySharedPreferences

class LoginForm : AppCompatActivity() {

   private lateinit var edtLoginEmail: EditText
   private lateinit var edtLoginPassword: EditText
   private lateinit var btnLogin: Button
   lateinit var sharedPreferences: MySharedPreferences

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_login_form)

      sharedPreferences = MySharedPreferences(this@LoginForm)

      edtLoginEmail = findViewById(R.id.loginEmail)
      edtLoginPassword = findViewById(R.id.loginPassword)
      btnLogin = findViewById(R.id.btnLogin)

      btnLogin.setOnClickListener {
         val strEmail = edtLoginEmail.text.toString()
         //val strPassword = edtLoginPassword.text.toString()
         if (strEmail.isEmpty()) {
            Toast.makeText(this@LoginForm, "Please Enter EmailAddress", Toast.LENGTH_SHORT).show()
         } else{

            sharedPreferences.saveEmail("UserEmail" , strEmail)
            sharedPreferences.saveIsLogInStatus("UserLoginStatus" , "True")

            startActivity(Intent(this@LoginForm, HomePageActivity::class.java))
         }
      }
   }

  /* private fun loginUser(strEmail: String, strPassword: String) {

      if (strEmail.isEmpty()) {
         Toast.makeText(this@LoginForm, "Please Enter EmailAddress", Toast.LENGTH_SHORT).show()
      } else if (strPassword.isEmpty()) {
         Toast.makeText(this@LoginForm, "Enter password", Toast.LENGTH_SHORT).show()
      } else {




        *//* Log.e("Email" , "Email:- $strEmail")
         Log.e("password" , "Password:- $strPassword")*//*

         startActivity(Intent(this@LoginForm, IntentsActivity::class.java))

      }

   }*/
}