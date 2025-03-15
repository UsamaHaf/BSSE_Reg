package com.usama.uos.bsse_reg.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.usama.uos.bsse_reg.Interface.Gmail_Interface
import com.usama.uos.bsse_reg.Models.GmailModel
import com.usama.uos.bsse_reg.R

class GmailAdapter(var gmailArrayList: ArrayList<GmailModel>, activity: Context?, var gmailInterface: Gmail_Interface) :
   RecyclerView.Adapter<GmailAdapter.GmailViewHolder>() {

   private var inflater: LayoutInflater = LayoutInflater.from(activity)


   inner class GmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      var userName: TextView = itemView.findViewById(R.id.txtUserName)
      var userDP: ImageView = itemView.findViewById(R.id.userDP)
      var mainGmailItemsLayout: RelativeLayout = itemView.findViewById(R.id.mainGmailItemsLayout)
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GmailViewHolder {
      val view = inflater.inflate(R.layout.list_items_gmail, null)
      return GmailViewHolder(view)
   }

   override fun getItemCount(): Int {
      return gmailArrayList.size
   }

   override fun onBindViewHolder(holder: GmailViewHolder, position: Int) {
      val model: GmailModel = gmailArrayList[position]
      holder.userDP.setImageResource(model.userDP)
      holder.userName.text = model.txtUserName

      holder.mainGmailItemsLayout.setOnClickListener { v ->
         gmailInterface.gmailItemClickListener(v, model, position)
      }


   }

}