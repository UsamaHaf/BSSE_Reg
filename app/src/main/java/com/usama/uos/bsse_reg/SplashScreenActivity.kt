package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.usama.uos.bsse_reg.SharedPref.MySharedPreferences

class SplashScreenActivity : AppCompatActivity() {

   lateinit var sharedPreferences: MySharedPreferences
   lateinit var firebaseAuth: FirebaseAuth

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_splash_screen)

      FirebaseApp.initializeApp(this@SplashScreenActivity)
      firebaseAuth = FirebaseAuth.getInstance()


      sharedPreferences = MySharedPreferences(this@SplashScreenActivity)

      Handler(Looper.getMainLooper()).postDelayed(Runnable {
         if(firebaseAuth.currentUser !=null){
            startActivity(Intent(this, HomePageActivity::class.java))
         }else{
            startActivity(Intent(this, LoginForm::class.java))
         }


      },1000)

      /*Handler().postDelayed(Runnable {

         if (sharedPreferences.getLoginStatus("UserLoginStatus") == "True") {
            startActivity(Intent(this, HomePageActivity::class.java))

         } else {
            startActivity(Intent(this, LoginForm::class.java))
         }


         //startActivity(Intent(this, RecyclerViewActivity::class.java))
      }, 1000)*/
   }
}