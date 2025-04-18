package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.usama.uos.bsse_reg.SharedPref.MySharedPreferences

class SplashScreenActivity : AppCompatActivity() {

   lateinit var sharedPreferences: MySharedPreferences

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_splash_screen)

      sharedPreferences = MySharedPreferences(this@SplashScreenActivity)

      /*Handler(Looper.getMainLooper()).postDelayed(Runnable {
         startActivity(Intent(this, IntentsActivity::class.java))
      },1000)*/

      Handler().postDelayed(Runnable {

         if(sharedPreferences.getLoginStatus("UserLoginStatus") == "True"){
            startActivity(Intent(this, HomePageActivity::class.java))

         }else{
            startActivity(Intent(this, LoginForm::class.java))
         }


         //startActivity(Intent(this, RecyclerViewActivity::class.java))
      }, 1000)
   }
}