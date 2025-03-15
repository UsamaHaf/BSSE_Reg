package com.usama.uos.bsse_reg.Interface

import android.view.View
import com.usama.uos.bsse_reg.Models.GmailModel

interface Gmail_Interface {

   fun gmailItemClickListener(view: View?, gmailModel: GmailModel, position: Int)

}