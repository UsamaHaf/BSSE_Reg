package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.usama.uos.bsse_reg.Models.UserModel

class SignUpForm : AppCompatActivity() {

   private lateinit var firebaseAuth: FirebaseAuth
   private lateinit var pbSIgnUp:ProgressBar

   override fun onCreate(savedInstanceState: Bundle?) {

      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_sign_up_form)

      firebaseAuth = FirebaseAuth.getInstance()


      pbSIgnUp = findViewById(R.id.pbSIgnUp)
      val btnSignUpForm = findViewById<Button>(R.id.btnSignup)
      val edtEmail = findViewById<EditText>(R.id.edtEmailAddress)
      val edtFirstName = findViewById<EditText>(R.id.edtFirstName)
      val edtLastName = findViewById<EditText>(R.id.edtLastName)
      val edtPassword = findViewById<EditText>(R.id.edtPassword)
      val edtPhoneNumber = findViewById<EditText>(R.id.edtPhoneNumber)

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
            val strPhoneNumber = edtPhoneNumber.text.toString()
            val strFName = edtFirstName.text.toString()
            val strLName = edtLastName.text.toString()

            signUpFirebaseUser(strEmail, strPassword , strPhoneNumber , strFName , strLName)
            pbSIgnUp.visibility = ProgressBar.VISIBLE


         }
      }

   }


   private fun signUpFirebaseUser(strEmail: String, strPassword: String, strPhoneNumber: String, strFName: String, strLName: String) {
      firebaseAuth.createUserWithEmailAndPassword(strEmail, strPassword).addOnCompleteListener { task ->

         if (task.isSuccessful) {
            pbSIgnUp.visibility = ProgressBar.GONE

            try {

               val userModel = UserModel()
               userModel.userEmail = strEmail
               userModel.userFirstName = strFName
               userModel.userLastName = strLName
               userModel.userPhoneNumber = strPhoneNumber
               userModel.userPassword = strPassword
               userModel.userUID = firebaseAuth.currentUser?.uid

               FirebaseDatabase.getInstance().getReference("Users")
                  .child(firebaseAuth.currentUser!!.uid).setValue(userModel)
                  .addOnCompleteListener { userTask->

                     if(userTask.isSuccessful){
                        Toast.makeText(this@SignUpForm, "SignUp Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@SignUpForm, LoginForm::class.java))
                     }else{
                        Toast.makeText(this@SignUpForm, "SignIn Failed: ${userTask.exception}", Toast.LENGTH_SHORT).show()
                     }

                  }





            }catch (e:Exception){
               Log.e("SignUpException" , "$e")
            }



         }else{

            Toast.makeText(this@SignUpForm, "SignIn Failed:- ${task.exception}", Toast.LENGTH_SHORT).show()
            pbSIgnUp.visibility = ProgressBar.GONE
            Log.e("FailedFirebase" , task.exception.toString())
            startActivity(Intent(this@SignUpForm, LoginForm::class.java))
         }


      }


   }


}