package com.usama.uos.bsse_reg

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MenusActivity : AppCompatActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_menus)

      val btnContextMenuShow = findViewById<TextView>(R.id.btnContextMenu)/*Context Menu*/
      registerForContextMenu(btnContextMenuShow)

      val btnPopUpMenuShow = findViewById<TextView>(R.id.btnPopUPMenu)/*PopUp Menu*/
      btnPopUpMenuShow.setOnClickListener {
         showPopUpMenu(btnPopUpMenuShow)
      }

   }

   private fun showPopUpMenu(view: View?) {
      val popup = PopupMenu(this, view)
      val inflater: MenuInflater = popup.menuInflater
      inflater.inflate(R.menu.pop_up_menu, popup.menu)
      popup.setOnMenuItemClickListener { menuItems ->

         when (menuItems.itemId) {
            R.id.aboutPopUp -> {
               Toast.makeText(this@MenusActivity, "About Popup", Toast.LENGTH_SHORT).show()
            }

            R.id.AppNameMenu -> {
               Toast.makeText(this@MenusActivity, "App Name Popup", Toast.LENGTH_SHORT).show()

            }
         }
         true
      }

      popup.show()
   }

   override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
      super.onCreateContextMenu(menu, v, menuInfo)
      menuInflater.inflate(R.menu.context_menu, menu)
   }

   override fun onContextItemSelected(item: MenuItem): Boolean {
      return when (item.itemId) {
         R.id.deleteMenu -> {
            Toast.makeText(this@MenusActivity, "Delete Meun", Toast.LENGTH_SHORT).show()
            true
         }

         R.id.editMenu -> {
            Toast.makeText(this@MenusActivity, "Edit Meu", Toast.LENGTH_SHORT).show()
            true
         }

         R.id.adminMenu -> {
            Toast.makeText(this@MenusActivity, "Make Admin Meu", Toast.LENGTH_SHORT).show()
            true
         }

         else -> super.onContextItemSelected(item)
      }
   }



   override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.option_menu, menu)
      return true
   }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
      return when (item.itemId) {
         R.id.profileMenu -> {
            Toast.makeText(this@MenusActivity, "Profile Menu", Toast.LENGTH_SHORT).show()

            true
         }

         R.id.settingsMenu -> {
            Toast.makeText(this@MenusActivity, "Settings Menu", Toast.LENGTH_SHORT).show()
            true
         }


         else -> super.onOptionsItemSelected(item)
      }

   }

}