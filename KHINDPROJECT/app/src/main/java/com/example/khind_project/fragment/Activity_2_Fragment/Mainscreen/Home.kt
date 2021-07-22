package com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.example.khind_project.MyViewPagerAdapter
import com.example.khind_project.R
import com.example.khind_project.fragment.Activity_2_Fragment.Notification.Notification
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : Fragment() {
    lateinit var bottom_navigation: BottomNavigationView
    lateinit var notficationBtn: Button
    lateinit var extendBtn: Button
    lateinit var viewpage: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val statusFragment = Status()
        val mapFragment = Map()
        val historyFragment = History()
        bottom_navigation = view.findViewById(R.id.Bottom_navigationBar)
        notficationBtn = view.findViewById(R.id.notification)
        extendBtn = view.findViewById(R.id.expandbutton)
        viewpage = view.findViewById(R.id.viewpager)

        val adapterViewPager = MyViewPagerAdapter(getChildFragmentManager())
        adapterViewPager.addFragment(statusFragment,"")
        adapterViewPager.addFragment(mapFragment,"")
        adapterViewPager.addFragment(historyFragment,"")
        viewpage.adapter = adapterViewPager

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.status -> {
                    //makeCurrentFragment(statusFragment)
                    viewpage.currentItem = 0
                }
                R.id.lightningmap -> {
                    //makeCurrentFragment(mapFragment)
                    viewpage.currentItem = 1
                }
                R.id.history -> {
                    //makeCurrentFragment(historyFragment)
                    viewpage.currentItem = 2
                }
            }
            true
        }

        viewpage.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> bottom_navigation.menu.findItem(R.id.status).setChecked(true)
                    1 -> bottom_navigation.menu.findItem(R.id.lightningmap).setChecked(true)
                    2 -> bottom_navigation.menu.findItem(R.id.history).setChecked(true)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })


        // notification button
        notficationBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2, Notification()).addToBackStack("Home")
                commit()
            }
        }


        // find more location button
        extendBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2, Location()).addToBackStack("Home")
                commit()
            }
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.fragment, fragment)
            commit()
        }
}