package com.usama.uos.bsse_reg.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.usama.uos.bsse_reg.Models.GmailModel
import com.usama.uos.bsse_reg.R

class GAdapter (var gmailArrayList:ArrayList<GmailModel> , activity:Context) :
   RecyclerView.Adapter<GAdapter.MyClassViewHolder>() {

      val inflater:LayoutInflater = LayoutInflater.from(activity)


   inner class MyClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

      val userDP:ImageView = itemView.findViewById(R.id.userDP)
      val userName:TextView = itemView.findViewById(R.id.txtUserName)

   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClassViewHolder {
      val view = inflater.inflate(R.layout.list_items_gmail , null)
      return  MyClassViewHolder(view)
   }

   override fun getItemCount(): Int {
     return gmailArrayList.size
   }

   override fun onBindViewHolder(holder: MyClassViewHolder, position: Int) {
      val model = gmailArrayList[position]

      holder.userDP.setImageResource(model.userDP)
      holder.userName.text = model.txtUserName

   }


}