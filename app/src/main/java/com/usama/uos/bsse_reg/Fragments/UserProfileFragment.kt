package com.usama.uos.bsse_reg.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.usama.uos.bsse_reg.R
import com.usama.uos.bsse_reg.SharedPref.MySharedPreferences


class UserProfileFragment : Fragment() {

   lateinit var sharedPreferences: MySharedPreferences
   lateinit var txtFragEmail:TextView
   lateinit var firebaseAuth: FirebaseAuth

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      val view =  inflater.inflate(R.layout.fragment_user_profile, container, false)

      sharedPreferences = MySharedPreferences(requireActivity())
      firebaseAuth = FirebaseAuth.getInstance()
      txtFragEmail = view.findViewById(R.id.txtFragEmail)
      txtFragEmail.text = firebaseAuth.currentUser?.email


      return view
   }


}