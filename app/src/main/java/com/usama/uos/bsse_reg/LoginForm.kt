package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.usama.uos.bsse_reg.SharedPref.MySharedPreferences

class LoginForm : AppCompatActivity() {

   private lateinit var edtLoginEmail: EditText
   private lateinit var edtLoginPassword: EditText
   private lateinit var btnLogin: Button
   private lateinit var createNewAccount: Button
   private lateinit var progressBarLogin: ProgressBar
   private lateinit var sharedPreferences: MySharedPreferences
   private lateinit var firebaseAuth: FirebaseAuth

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_login_form)
      firebaseAuth = FirebaseAuth.getInstance()

      sharedPreferences = MySharedPreferences(this@LoginForm)

      edtLoginEmail = findViewById(R.id.loginEmail)
      edtLoginPassword = findViewById(R.id.loginPassword)
      btnLogin = findViewById(R.id.btnLogin)
      createNewAccount = findViewById(R.id.createNewAccount)
      progressBarLogin = findViewById(R.id.progressBarLogin)

      createNewAccount.setOnClickListener {
         startActivity(Intent(this@LoginForm , SignUpForm::class.java))
      }

      btnLogin.setOnClickListener {
         val strEmail = edtLoginEmail.text.toString()
         val strPassword = edtLoginPassword.text.toString()

         if (strEmail.isEmpty()) {
            Toast.makeText(this@LoginForm, "Please Enter EmailAddress", Toast.LENGTH_SHORT).show()
         } else if (strPassword.isEmpty()) {
            Toast.makeText(this@LoginForm, "Please Enter Password", Toast.LENGTH_SHORT).show()
         } else {

            signInUser(strEmail, strPassword)
            progressBarLogin.visibility = ProgressBar.VISIBLE

         }
      }
   }

   private fun signInUser(strEmail: String, strPassword: String) {
      firebaseAuth.signInWithEmailAndPassword(strEmail, strPassword)
         .addOnCompleteListener { task ->

            if(task.isSuccessful){
               progressBarLogin.visibility = ProgressBar.GONE

               Toast.makeText(this@LoginForm , "SignIn Successful" , Toast.LENGTH_SHORT).show()
               startActivity(Intent(this@LoginForm , HomePageActivity::class.java))


            }else{
               progressBarLogin.visibility = ProgressBar.GONE
               Toast.makeText(this@LoginForm , "SignIn Failed: ${task.exception}" , Toast.LENGTH_SHORT).show()
            }

      }
   }


   /*
  sharedPreferences.saveEmail("UserEmail" , strEmail)
            sharedPreferences.saveIsLogInStatus("UserLoginStatus" , "True")

            startActivity(Intent(this@LoginForm, HomePageActivity::class.java))
  private fun loginUser(strEmail: String, strPassword: String) {


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