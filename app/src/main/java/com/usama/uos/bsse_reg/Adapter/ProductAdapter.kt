package com.usama.uos.bsse_reg.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.usama.uos.bsse_reg.Interface.StoreInterfaces
import com.usama.uos.bsse_reg.Models.ProductsModel
import com.usama.uos.bsse_reg.R


class ProductAdapter(private var arrayListProduct: ArrayList<ProductsModel>, context: Context, var storeListeners: StoreInterfaces) :
   RecyclerView.Adapter<ProductAdapter.MyProductViewHolder>() {

      val infaltor:LayoutInflater = LayoutInflater.from(context)

   inner class MyProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

      val txtItemRetailPrice: TextView = itemView.findViewById(R.id.txtItemRetailPrice)
      val txtProductName: TextView = itemView.findViewById(R.id.txtProductName)
      val btnAddToCart: TextView = itemView.findViewById(R.id.btnAddToCart)
      val btnAdditionLayout: LinearLayout = itemView.findViewById(R.id.btnAdditionLayout)
      val btnMinusDelete: ImageView = itemView.findViewById(R.id.btnMinusDelete)
      val btnPlus: ImageView = itemView.findViewById(R.id.btnPlus)
      val txtItemQuantity: EditText = itemView.findViewById(R.id.txtItemQuantity)

   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProductViewHolder {
      val view =  infaltor.inflate(R.layout.list_items_product, null)

      return MyProductViewHolder(view)

   }

   override fun getItemCount(): Int {
      return arrayListProduct.size
   }

   override fun onBindViewHolder(holder: MyProductViewHolder, position: Int) {
      val model = arrayListProduct[position]

      holder.txtProductName.setText(model.productName)
      holder.txtItemRetailPrice.setText("Rs. "+model.productSalePrice)

      holder.btnAddToCart.setOnClickListener { view ->

         storeListeners.addToCartClickListener(view,model,position)


      }

   }


}