package com.usama.uos.bsse_reg

import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.net.URLEncoder

class IntentsActivity : AppCompatActivity() {

   lateinit var edtWebSearch: EditText
   lateinit var edtGoogleSearch: EditText
   lateinit var edtPhoneNo: EditText
   lateinit var btnWebSearch: Button
   lateinit var btnGoogleSearch: Button
   lateinit var btnMakeCall: Button
   lateinit var btnSendSMS: Button

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_intents)

      edtWebSearch = findViewById(R.id.searchWebEdt)
      edtGoogleSearch = findViewById(R.id.searchGoogleEdt)
      btnWebSearch = findViewById(R.id.btnSearchWeb)
      btnGoogleSearch = findViewById(R.id.btnSearchGoogle)
      btnMakeCall = findViewById(R.id.btnMakeCall)
      edtPhoneNo = findViewById(R.id.edtPhoneNo)
      btnSendSMS = findViewById(R.id.btnSendSMS)

      btnSendSMS.setOnClickListener {
         if(ContextCompat.checkSelfPermission(this , android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this , arrayOf(android.Manifest.permission.SEND_SMS) , 100)
         }else{
            //val sendPI = PendingIntent
         }
      }

      btnMakeCall.setOnClickListener {

         if(ContextCompat.checkSelfPermission(this , android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this , arrayOf(android.Manifest.permission.CALL_PHONE) , 100)
         }else{
            val intent = Intent(Intent.ACTION_CALL , Uri.parse("tel:" + edtPhoneNo.text.toString()))
            startActivity(intent)
         }


      }


      btnWebSearch.setOnClickListener {
         val strWebTxt = edtWebSearch.text.toString()
         val intent = Intent(Intent.ACTION_VIEW)
         intent.setData(Uri.parse("https://www.${strWebTxt}.com"))
         startActivity(intent)
      }

      btnGoogleSearch.setOnClickListener {
         val strGoogleText = edtGoogleSearch.text.toString()
         val query = URLEncoder.encode(strGoogleText, "UTF-8")
         val uri = Uri.parse("https://www.google.com/search?q=${query}")
         val intent = Intent(Intent.ACTION_VIEW, uri)
         startActivity(intent)
      }


   }
}