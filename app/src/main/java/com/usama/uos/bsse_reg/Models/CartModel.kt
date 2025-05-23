package com.usama.uos.bsse_reg.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class CartModel : Serializable {

   @PrimaryKey(autoGenerate = true)
   var id:Int = 0

   @ColumnInfo(name = "ProductName")
   var productName:String? = null

   @ColumnInfo(name = "ProductInventory")
   var productInventory:Int? = null

   @ColumnInfo(name = "ProductPrice")
   var productPrice:Double? = null

   @ColumnInfo(name = "ProductQuantity")
   var productQuantity:Int? = null

   @ColumnInfo(name = "ProductID")
   var productID:String? = null

}