package com.usama.uos.bsse_reg

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.usama.uos.bsse_reg.Adapter.GmailAdapter
import com.usama.uos.bsse_reg.Models.GmailModel

class RecyclerViewActivity : AppCompatActivity() {

   private lateinit var rvGMail: RecyclerView
   lateinit var gmailArrayList: ArrayList<GmailModel>

   var userName = arrayOf("CR BSSE" , "Hafeez" ,"BSSE 4th Regular")
   var userDP = arrayOf(R.drawable.whatsapp , R.drawable.ic_background1, R.drawable.ic_chats)

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_recycler_view)

      rvGMail = findViewById(R.id.rvMainRecyclerview)
      gmailArrayList = ArrayList()

      for(i in userDP.indices){

         val gmailModel = GmailModel(userDP[i], userName[i])
         gmailArrayList.add(gmailModel)
      }

      if(gmailArrayList != null){
         val adapterGmail = GmailAdapter(gmailArrayList , this@RecyclerViewActivity)
         rvGMail.adapter = adapterGmail

      }


   }
}