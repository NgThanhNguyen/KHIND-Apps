package com.example.khind_project

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.khind_project.fragment.Activity_2_Fragment.About
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.detect.Map
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.history.History
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.location.Location
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.status.Status
import com.example.khind_project.fragment.Activity_2_Fragment.Notification.Notification
import com.example.khind_project.fragment.Activity_2_Fragment.Profile
import com.example.khind_project.fragment.Activity_2_Fragment.Setting
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class SecondActivity : AppCompatActivity() {
    //private lateinit var SensorDataViewModel: ActivityViewModels
    private lateinit var navDrawerButton: Button
    private lateinit var notificationButton: Button
    lateinit var extendBtn: Button
    lateinit var toolBar: ConstraintLayout
    lateinit var navBar: ConstraintLayout
    lateinit var location: ConstraintLayout
    lateinit var seperate: View
    lateinit var drawer: DrawerLayout
    lateinit var navigationView: NavigationView
    private lateinit var bottom_navigation: BottomNavigationView
    private lateinit var toolbarTitle: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intit()
        viewHandle()

        addFragmentToActivity(supportFragmentManager, Status(), R.id.fragmentContainer2)
    }

    private fun intit() {
        navDrawerButton = findViewById(R.id.nav_button)
        notificationButton = findViewById(R.id.noti)
        toolBar = findViewById(R.id.toolbar)
        drawer = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        bottom_navigation = findViewById(R.id.Bottom_navigationBar)
        toolbarTitle = findViewById(R.id.toolbar_title)
        navBar = findViewById(R.id.nav_bar)
        location = findViewById(R.id.location_constraint)
        extendBtn = findViewById(R.id.expandbutton)

    }

    private fun viewHandle() {
        // notification button
        notificationButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer2, Notification())
                addToBackStack("Notification")
                commit()
            }
        }

        extendBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer2, Location())
                addToBackStack("Location")
                commit()
            }
        }

        // navigation drawer button

        navDrawerButton.setOnClickListener {

            drawer.openDrawer(GravityCompat.START)
        }

        // handle bottom navigation

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.status -> {
                    makeCurrentFragment(Status())
                    //viewpage.currentItem = 0
                }
                R.id.lightningmap -> {
                    makeCurrentFragment(Map())
                    //viewpage.currentItem = 1
                }
                R.id.history -> {
                    makeCurrentFragment(History())
                    //viewpage.currentItem = 2
                }
            }
            true
        }

        // handle navigation on click menu item

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.dashboard -> {
                    toolBar.visibility = View.VISIBLE
                    navBar.visibility = View.VISIBLE
                    location.visibility = View.VISIBLE
                    drawer.closeDrawer(GravityCompat.START)
                    Toast.makeText(this,"Selected Dashboard",Toast.LENGTH_LONG).show()
                    makeCurrentFragment(Status())
                    toolbarTitle.text = "Dashboard"

                }
                R.id.notice -> {
                    drawer.closeDrawer(GravityCompat.START)
                    Toast.makeText(this,"Selected Notification",Toast.LENGTH_LONG).show()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainer2,Notification())
                        addToBackStack("Notification")
                        commit()
                    }

                }
                R.id.myprofile -> {
                    drawer.closeDrawer(GravityCompat.START)
                    Toast.makeText(this,"Selected My Profile",Toast.LENGTH_LONG).show()
                    toolbarTitle.text = "My Profile"
                    makeCurrentFragment(Profile())


                }
                R.id.setting -> {
                    drawer.closeDrawer(GravityCompat.START)
                    Toast.makeText(this,"Selected Setting",Toast.LENGTH_LONG).show()
                    toolbarTitle.text = "Setting"
                    makeCurrentFragment(Setting())
                }
                R.id.support -> {
                    drawer.closeDrawer(GravityCompat.START)
                    Toast.makeText(this,"Selected Support",Toast.LENGTH_LONG).show()
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainer2,About())
                        addToBackStack("Support")
                        commit()
                    }
                }
            }
            true
        }
    }


    private fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment?, frameId: Int) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        if (fragment != null) {
            transaction.add(frameId, fragment)
        }
        transaction.commit()
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer2,fragment)
            commit()
        }
}