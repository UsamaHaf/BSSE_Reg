package com.usama.uos.bsse_reg.Interface

import android.view.View
import com.usama.uos.bsse_reg.Models.UserModel

interface UserItemClick {

   fun userItemClickListener(view: View?, userModel: UserModel, position: Int)

}