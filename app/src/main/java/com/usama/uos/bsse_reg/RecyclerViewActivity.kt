package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.usama.uos.bsse_reg.Adapter.GmailAdapter
import com.usama.uos.bsse_reg.Interface.Gmail_Interface
import com.usama.uos.bsse_reg.Models.GmailModel

class RecyclerViewActivity : AppCompatActivity(), Gmail_Interface {

   private lateinit var rvGMail: RecyclerView
   lateinit var gmailArrayList: ArrayList<GmailModel>

   var userName = arrayOf("CR BSSE", "Hafeez", "BSSE 4th Regular")
   var userDP = arrayOf(R.drawable.whatsapp, R.drawable.ic_background1, R.drawable.ic_chats)

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_recycler_view)

      rvGMail = findViewById(R.id.rvMainRecyclerview)
      gmailArrayList = ArrayList()

      for (i in userDP.indices) {

         val gmailModel = GmailModel(userDP[i], userName[i])
         gmailArrayList.add(gmailModel)
      }

      if (gmailArrayList != null) {
         val adapterGmail =
             GmailAdapter(gmailArrayList, this@RecyclerViewActivity, this@RecyclerViewActivity)
         rvGMail.adapter = adapterGmail

      }


   }

   override fun gmailItemClickListener(view: View?, gmailModel: GmailModel, position: Int) {
      Toast.makeText(this, gmailModel.txtUserName, Toast.LENGTH_SHORT).show()

      startActivity(Intent(this@RecyclerViewActivity, MenusActivity::class.java))

   }
}