package com.usama.uos.bsse_reg.SharedPref

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(context: Context) {

   private val sharedPreferences: SharedPreferences =
       context.getSharedPreferences("RegSharedPref", Context.MODE_PRIVATE)

   fun saveEmail(key: String, value: String) {
      val editor = sharedPreferences.edit()
      editor.putString(key, value)
      editor.apply()
   }

   fun getEmail(key: String): String? {
      return sharedPreferences.getString(key, "")
   }

   fun saveIsLogInStatus(key: String, value: String) {
      val editor = sharedPreferences.edit()
      editor.putString(key, value)
      editor.apply()
   }

   fun getLoginStatus(key: String): String? {
      return sharedPreferences.getString(key, "")
   }


}