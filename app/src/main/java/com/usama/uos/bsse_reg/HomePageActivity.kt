package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.usama.uos.bsse_reg.SharedPref.MySharedPreferences

class HomePageActivity : AppCompatActivity() {

   lateinit var  txtWelcomeText:TextView
   lateinit var  btnLogoutUser:Button
   lateinit var sharedPreferences: MySharedPreferences

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_home_page)

      sharedPreferences = MySharedPreferences(this@HomePageActivity)

      txtWelcomeText = findViewById(R.id.txtWelcomeText)
      btnLogoutUser = findViewById(R.id.btnLogoutUser)
      txtWelcomeText.text =   "Welcome Mr. ${sharedPreferences.getEmail("UserEmail")}"

      btnLogoutUser.setOnClickListener {

         sharedPreferences.saveIsLogInStatus("UserLoginStatus" , "False")
         startActivity(Intent(this@HomePageActivity , LoginForm::class.java))

         Toast.makeText(this , "Logout Successfully" , Toast.LENGTH_SHORT).show()
      }


      //val receivedData = intent.getStringExtra("TestData")

     /* if(receivedData!= null){

      }else{

         txtWelcomeText.text =   "No Data Recieved"

      }*/



   }
}