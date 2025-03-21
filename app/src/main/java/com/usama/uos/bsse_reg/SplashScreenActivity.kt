package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_splash_screen)

      /*Handler(Looper.getMainLooper()).postDelayed(Runnable {
         startActivity(Intent(this, IntentsActivity::class.java))
      },1000)*/

      Handler().postDelayed(Runnable {
         startActivity(Intent(this, RecyclerViewActivity::class.java))
      }, 1000)
   }
}