package com.usama.uos.bsse_reg.DAO

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.usama.uos.bsse_reg.Models.CartModel


public  interface CartDAO {


   @Query("Select * from CartModel")
   fun getAll():List<CartModel>?

   /*
   @Query("Select * from CartModel")
   fun getAll(): List<CartModel?>?*/

   @Query("Delete FROM CartModel")
   fun deleteAll()

   @Query("SELECT COUNT(*) FROM CartModel")
   fun totalCartItems(): Int

   @Query("SELECT EXISTS(SELECT * FROM CartModel where ProductID == :productID)")
   fun isAlreadyExist(productID: String?): Boolean

   @Query("SELECT ProductQuantity FROM CartModel where ProductID == :productID")
   fun fetchProductQuantity(productID: String?): Double?

   @Query("UPDATE CartModel SET ProductQuantity=:quantity WHERE ProductID = :productID")
   fun updateQuantity(quantity: Double?, productID: String?)

   @Query("Delete FROM CartModel where ProductID == :productID")
   fun deleteProduct(productID: String?)

   @Insert
   fun insert(cartModel: CartModel?)

   @Delete
   fun delete(cartModel: CartModel?)

   @Update
   fun update(cartModel: CartModel?)

}