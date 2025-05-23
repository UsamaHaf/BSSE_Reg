package com.usama.uos.bsse_reg.Databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usama.uos.bsse_reg.DAO.CartDAO
import com.usama.uos.bsse_reg.Models.CartModel


@Database(entities = [CartModel::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {

   abstract fun cartDAO(): CartDAO


}