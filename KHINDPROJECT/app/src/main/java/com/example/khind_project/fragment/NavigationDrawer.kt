package com.example.khind_project.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.khind_project.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.navigation_drawer.*
import kotlinx.android.synthetic.main.toolbar.*

class NavigationDrawer : Fragment() {
    lateinit var toogle: ActionBarDrawerToggle
    lateinit var navigationView: NavigationView
    lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.navigation_drawer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigationView = view.findViewById(R.id.nav_view)
        drawer = view.findViewById(R.id.drawerLayout)

        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        toogle = ActionBarDrawerToggle((activity as AppCompatActivity?),drawer,R.string.open,R.string.close)
        toogle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowTitleEnabled(false)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.dashboard -> Toast.makeText(this.context,"Selected Dashboard",Toast.LENGTH_LONG).show()
                R.id.notice -> Toast.makeText(this.context,"Selected Dashboard",Toast.LENGTH_LONG).show()
                R.id.myprofile -> Toast.makeText(this.context,"Selected Dashboard",Toast.LENGTH_LONG).show()
                R.id.setting -> Toast.makeText(this.context,"Selected Dashboard",Toast.LENGTH_LONG).show()
                R.id.support -> Toast.makeText(this.context,"Selected Dashboard",Toast.LENGTH_LONG).show()
            }
            true
        }
    }
}