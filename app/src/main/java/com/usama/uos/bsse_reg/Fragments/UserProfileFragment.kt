package com.usama.uos.bsse_reg.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson
import com.usama.uos.bsse_reg.Adapter.UsersAdapter
import com.usama.uos.bsse_reg.Interface.UserItemClick
import com.usama.uos.bsse_reg.Models.UserModel
import com.usama.uos.bsse_reg.R
import com.usama.uos.bsse_reg.SharedPref.MySharedPreferences


class UserProfileFragment : Fragment(), UserItemClick {

   private lateinit var sharedPreferences: MySharedPreferences
   lateinit var txtNoDataYet: TextView

   lateinit var pbUsers: ProgressBar
   lateinit var rvUsers: RecyclerView
   lateinit var firebaseAuth: FirebaseAuth

   lateinit var usersAdapter: UsersAdapter
   lateinit var userDataArrayList: ArrayList<UserModel>
   lateinit var firebaseDatabase: FirebaseDatabase
   lateinit var firebaseReference: DatabaseReference

   override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      val view = inflater.inflate(R.layout.fragment_user_profile, container, false)

      sharedPreferences = MySharedPreferences(requireActivity())
      firebaseAuth = FirebaseAuth.getInstance()

      txtNoDataYet = view.findViewById(R.id.txtNoDataYet)
      pbUsers = view.findViewById(R.id.pbUsers)
      rvUsers = view.findViewById(R.id.rvUsers)


      getUsers()

      return view
   }

   private fun getUsers() {
      pbUsers.visibility = ProgressBar.VISIBLE
      firebaseDatabase = FirebaseDatabase.getInstance()
      firebaseReference = firebaseDatabase.getReference("Users")
      userDataArrayList = ArrayList()

      firebaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
         override fun onDataChange(snapshot: DataSnapshot) {
            try {
               userDataArrayList.clear()
               for (eachUser in snapshot.children) {
                  val modelUser: UserModel? = eachUser.getValue(UserModel::class.java)
                  userDataArrayList.add(modelUser!!)
               }

               if (userDataArrayList == null || userDataArrayList.size == 0) {
                  pbUsers.visibility = ProgressBar.GONE
                  txtNoDataYet.visibility = TextView.VISIBLE
               } else {
                  usersAdapter =
                      UsersAdapter(userDataArrayList, requireActivity(), this@UserProfileFragment)
                  rvUsers.adapter = usersAdapter
                  pbUsers.visibility = ProgressBar.GONE
               }


            } catch (e: Exception) {
               Log.e("DBError:-", e.toString())
            }


         }

         override fun onCancelled(error: DatabaseError) {
            Log.e("DBError", error.message)
         }

      })


   }

   override fun userItemClickListener(view: View?, userModel: UserModel, position: Int) {
      val bundle = Bundle()
      bundle.putString("UserDetails", Gson().toJson(userModel))
      val nextFragment = UpdateUserFragment()
      nextFragment.arguments = bundle
      setFragment(nextFragment, "")


   }

   private fun setFragment(fragment: Fragment?, title: String) {
      requireActivity().supportFragmentManager.beginTransaction()
         .replace(R.id.fragmentContainer, fragment!!).addToBackStack(null).commit()
   }


}

//txtFragEmail.text = firebaseAuth.currentUser?.email
