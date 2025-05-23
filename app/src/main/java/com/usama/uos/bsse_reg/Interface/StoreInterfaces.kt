package com.usama.uos.bsse_reg.Interface

import android.view.View
import com.usama.uos.bsse_reg.Models.ProductsModel

interface StoreInterfaces {

   fun addToCartClickListener(view: View?, stockModel: ProductsModel?, position: Int)

   fun onPlusClick(view: View?, stockModel: ProductsModel?, position: Int)

   fun onDeleteClick(view: View?, stockModel: ProductsModel?, position: Int)


}