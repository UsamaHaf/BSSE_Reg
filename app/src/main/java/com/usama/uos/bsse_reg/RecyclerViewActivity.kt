package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.usama.uos.bsse_reg.Adapter.GAdapter
import com.usama.uos.bsse_reg.Adapter.GmailAdapter
import com.usama.uos.bsse_reg.Interface.Gmail_Interface
import com.usama.uos.bsse_reg.Models.GmailModel

class RecyclerViewActivity : AppCompatActivity(), Gmail_Interface {

   private lateinit var rvGMail: RecyclerView
   lateinit var gmailArrayList: ArrayList<GmailModel>

   var userName = arrayOf("CR BSSE", "Sheryar", "BSSE 4th Regular")
   var userDP = arrayOf(R.drawable.whatsapp, R.drawable.ic_background1, R.drawable.ic_chats)

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_recycler_view)

      rvGMail = findViewById(R.id.rvMainRecyclerview)
      gmailArrayList = ArrayList()


      //for(i , i<10 , i++)
      //for(i , i<userDP.size , i++)

      for (i in userDP.indices) {
         val gmailModel = GmailModel(userDP[i], userName[i])
         gmailArrayList.add(gmailModel)
      }

      if (gmailArrayList != null) {
         val adapterGmail = GAdapter(gmailArrayList , this@RecyclerViewActivity)

         rvGMail.adapter = adapterGmail

      } else {
         Toast.makeText(this@RecyclerViewActivity, "No Data", Toast.LENGTH_SHORT).show()
      }


   }


   override fun gmailItemClickListener(view: View?, gmailModel: GmailModel, position: Int) {
      Toast.makeText(this, gmailModel.txtUserName, Toast.LENGTH_SHORT).show()

      val intent = Intent(this@RecyclerViewActivity, HomePageActivity::class.java)
      intent.putExtra("TestData", gmailModel.txtUserName)
      //intent.putExtra("TestData",  "Testing Data From User")
      startActivity(intent)

   }
}