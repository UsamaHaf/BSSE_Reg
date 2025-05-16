package com.usama.uos.bsse_reg.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.usama.uos.bsse_reg.Models.UserModel
import com.usama.uos.bsse_reg.R

class UsersAdapter(var userDataArrayList: ArrayList<UserModel>, context: Context) :
   RecyclerView.Adapter<UsersAdapter.MyUserViewHolder>() {

   val inflator: LayoutInflater = LayoutInflater.from(context)

   inner class MyUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      var txtUserName = itemView.findViewById<TextView>(R.id.txtUserName)
      var txtUserEmail = itemView.findViewById<TextView>(R.id.txtUserEmail)

   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyUserViewHolder {
      val view = inflator.inflate(R.layout.list_items_users, null)

      return MyUserViewHolder(view)
   }

   override fun getItemCount(): Int {
      return userDataArrayList.size
   }

   override fun onBindViewHolder(holder: MyUserViewHolder, position: Int) {
      val model = userDataArrayList[position]
      holder.txtUserName.text = model.userFirstName + model.userLastName
      holder.txtUserEmail.text = model.userEmail
   }

}