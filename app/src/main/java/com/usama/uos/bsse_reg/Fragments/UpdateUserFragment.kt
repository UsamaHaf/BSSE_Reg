package com.usama.uos.bsse_reg.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import com.usama.uos.bsse_reg.Models.UserModel
import com.usama.uos.bsse_reg.R


class UpdateUserFragment : Fragment() {

   lateinit var userModel: UserModel
   lateinit var firebaseAuth: FirebaseAuth
   lateinit var edtUpdateUserName: EditText
   lateinit var btnUpdateData: Button

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      val view = inflater.inflate(R.layout.fragment_about_us, container, false)

      firebaseAuth = FirebaseAuth.getInstance()
      edtUpdateUserName = view.findViewById(R.id.edtUpdateUserName)
      btnUpdateData = view.findViewById(R.id.btnUpdateData)


      return view
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      val bundle = arguments
      if (bundle != null) {
         try {
            userModel = Gson().fromJson(bundle.getString("UserDetails"), UserModel::class.java)
            edtUpdateUserName.setText(userModel.userFirstName)

         } catch (e: Exception) {
            Log.e("Bundles Error", e.toString())
         }
      }

      btnUpdateData.setOnClickListener {
         val strUserName = edtUpdateUserName.text.toString()

         FirebaseDatabase.getInstance().getReference("Users").child(userModel.userUID!!).setValue(strUserName)



      }


   }


}