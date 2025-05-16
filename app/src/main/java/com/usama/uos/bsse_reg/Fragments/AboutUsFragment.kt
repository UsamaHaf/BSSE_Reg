package com.usama.uos.bsse_reg.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import com.usama.uos.bsse_reg.Models.UserModel
import com.usama.uos.bsse_reg.R


class AboutUsFragment : Fragment() {

   lateinit var userModel: UserModel
   lateinit var firebaseAuth: FirebaseAuth


   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      val view = inflater.inflate(R.layout.fragment_about_us, container, false)

      firebaseAuth = FirebaseAuth.getInstance()

      return view
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      val bundle = arguments
      if (bundle != null) {
         try {

            userModel = Gson().fromJson(bundle.getString("UserDetails"), UserModel::class.java)
            Log.i("Bundle_Data", userModel.userEmail.toString())


         } catch (e: Exception) {
            Log.e("Bundles Error", e.toString())
         }
      }

   }


}