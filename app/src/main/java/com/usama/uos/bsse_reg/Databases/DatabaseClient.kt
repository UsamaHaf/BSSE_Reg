package com.usama.uos.bsse_reg.Databases

import android.content.Context
import androidx.room.Room.databaseBuilder

class DatabaseClient private constructor(private val context: Context) {
   val userDatabase: ProductDatabase =
       databaseBuilder(context, ProductDatabase::class.java, "ProductDatabase").allowMainThreadQueries()
          .build()

   companion object {
      private var mIstance: DatabaseClient? = null

      @Synchronized
      fun getInstance(mCtx: Context): DatabaseClient {
         if (mIstance == null) {
            mIstance = DatabaseClient(mCtx)
         }
         return mIstance!!
      }
   }
}