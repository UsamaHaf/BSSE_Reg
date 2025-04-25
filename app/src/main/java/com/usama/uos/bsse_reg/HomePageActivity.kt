package com.usama.uos.bsse_reg

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.usama.uos.bsse_reg.Fragments.AboutUsFragment
import com.usama.uos.bsse_reg.Fragments.UserProfileFragment
import com.usama.uos.bsse_reg.SharedPref.MySharedPreferences

class HomePageActivity : AppCompatActivity() {

   lateinit var mainDrawerLayout: DrawerLayout
   lateinit var btnOpenSideMenu: ImageView
   lateinit var navigationDrawer: NavigationView
   lateinit var appBarTitle: TextView
   lateinit var sharedPreferences: MySharedPreferences

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_home_page)

      sharedPreferences = MySharedPreferences(this@HomePageActivity)

      navigationDrawer = findViewById(R.id.navigationDrawer)
      mainDrawerLayout = findViewById(R.id.mainDrawerLayout)
      btnOpenSideMenu = findViewById(R.id.btnOpenSideMenu)
      appBarTitle = findViewById(R.id.appBarTitle)

      mainDrawerLayout.closeDrawer(GravityCompat.START)

      btnOpenSideMenu.setOnClickListener {
         mainDrawerLayout.openDrawer(GravityCompat.START)
      }
      setFragment(UserProfileFragment() , "User Profile")

      val headerView: View  = navigationDrawer.getHeaderView(0)
      val userEmail = headerView.findViewById<TextView>(R.id.txtAccEmail)
      userEmail.text = sharedPreferences.getEmail("UserEmail")


      val toggle =
          ActionBarDrawerToggle(this@HomePageActivity, mainDrawerLayout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
      mainDrawerLayout.addDrawerListener(toggle)
      toggle.syncState()

      navigationDrawer.setNavigationItemSelectedListener { menuItems ->
         when (menuItems.itemId) {
            R.id.userProfile -> {
               setFragment(UserProfileFragment() , "User Profile")
            }

            R.id.aboutUs -> {
               setFragment(AboutUsFragment() , "About Us")
            }

            R.id.logoutUser -> {
               sharedPreferences.saveIsLogInStatus("UserLoginStatus" , "False")
               startActivity(Intent(this@HomePageActivity , LoginForm::class.java))
               Toast.makeText(this , "Logout Successfully" , Toast.LENGTH_SHORT).show()
            }
         }
         true
      }

   }

   private fun setFragment(fragment: Fragment?, title: String) {
      this@HomePageActivity.supportFragmentManager.beginTransaction()
         .replace(R.id.fragmentContainer, fragment!!)
         .addToBackStack(null)
         .commit()

      appBarTitle.text = title
      mainDrawerLayout.closeDrawer(GravityCompat.START)


   }


   /*

   txtWelcomeText = findViewById(R.id.txtWelcomeText)
   btnLogoutUser = findViewById(R.id.btnLogoutUser)
   txtWelcomeText.text =   "Welcome Mr. ${sharedPreferences.getEmail("UserEmail")}"

   btnLogoutUser.setOnClickListener {
      sharedPreferences.saveIsLogInStatus("UserLoginStatus" , "False")
      startActivity(Intent(this@HomePageActivity , LoginForm::class.java))
      Toast.makeText(this , "Logout Successfully" , Toast.LENGTH_SHORT).show()
   }*//*
     val receivedData = intent.getStringExtra("TestData")
     if(receivedData!= null){
      }else{
         txtWelcomeText.text =   "No Data Recieved"
      }*/


}
