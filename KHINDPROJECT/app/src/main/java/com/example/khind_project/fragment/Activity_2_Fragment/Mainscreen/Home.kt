package com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.khind_project.MyViewPagerAdapter
import com.example.khind_project.R
import com.example.khind_project.fragment.Activity_2_Fragment.Dashboard
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.detect.Map
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.history.History
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.location.Location
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.status.Status
import com.example.khind_project.fragment.Activity_2_Fragment.Notification.Notification
import com.example.khind_project.fragment.Activity_2_Fragment.Profile
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.toolbar.*

class Home : Fragment() {

    lateinit var notficationBtn: Button
    lateinit var toogle: ActionBarDrawerToggle
    lateinit var navigationView: NavigationView
    lateinit var drawer: DrawerLayout
    lateinit var toolbarTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val activity = activity as AppCompatActivity?
//
//
//        val toogle = ActionBarDrawerToggle(this.activity,drawerLayout,toolbar,R.string.open,R.string.close)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notficationBtn = view.findViewById(R.id.notification)
        navigationView = view.findViewById(R.id.nav_view)
        drawer = view.findViewById(R.id.drawerLayout)
        toolbarTitle = view.findViewById(R.id.toolbar_title)



        // notification button
        notficationBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2, Notification()).addToBackStack("Notification")
                commit()
            }
        }

        // setting up navigation drawer
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        toogle = ActionBarDrawerToggle((activity as AppCompatActivity?),drawer,R.string.open,R.string.close)
        toogle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowTitleEnabled(false)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)

        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.frag_nav_view,Dashboard())
            commit()
        }

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.dashboard -> {
                    Toast.makeText(this.context,"Selected Dashboard",Toast.LENGTH_LONG).show()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frag_nav_view,Dashboard())
                        commit()
                    }
                    toolbarTitle.text = "Dashboard"
                    navigationView.visibility = View.GONE

                }
                R.id.notice -> {
                    Toast.makeText(this.context,"Selected Notification",Toast.LENGTH_LONG).show()
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.fragmentContainer2,Notification())
                        addToBackStack("Notification")
                        commit()
                    }
                }
                R.id.myprofile -> {
                    Toast.makeText(this.context,"Selected My Profile",Toast.LENGTH_LONG).show()
                    toolbarTitle.text = "My Profile"
                    fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.frag_nav_view, Profile())
                        commit()
                    }
                    navigationView.visibility = View.GONE

                }
                R.id.setting -> Toast.makeText(this.context,"Selected Setting",Toast.LENGTH_LONG).show()
                R.id.support -> Toast.makeText(this.context,"Selected Support",Toast.LENGTH_LONG).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)) {
            return true
        }
//        when(item.itemId) {
//            R.id.home -> {
//                drawer.openDrawer(GravityCompat.START)
//                return true
//            }
//        }
        return super.onOptionsItemSelected(item)

    }


}