package com.example.khind_project.fragment.Activity_2_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.khind_project.R
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.detect.Map
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.history.History
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.location.Location
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.status.Status
import com.google.android.material.bottomnavigation.BottomNavigationView

class Dashboard : Fragment() {
    lateinit var bottom_navigation: BottomNavigationView
    lateinit var extendBtn: Button
    //lateinit var viewpage: ViewPager
    private var check: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val statusFragment = Status()
        val mapFragment = Map()
        val historyFragment = History()
        bottom_navigation = view.findViewById(R.id.Bottom_navigationBar)
        extendBtn = view.findViewById(R.id.expandbutton)
        //viewpage = view.findViewById(R.id.viewpager)

        /////////////////////////////////////////////////////////////////////////////////////////////////

        // Setting view pager and navigation bar

//        val adapterViewPager = MyViewPagerAdapter(requireFragmentManager())
//        if(check == 0) {
//            adapterViewPager.addFragment(statusFragment, "")
//        }
//        else if(check == 1) {
//            adapterViewPager.addFragment(mapFragment, "")
//        }
//        else if(check == 2) {
//            adapterViewPager.addFragment(historyFragment, "")
//        }
//        viewpage.adapter = adapterViewPager
        if(check == 0) {
            makeCurrentFragment(statusFragment,R.id.fragment)
        }
        else if(check == 1) {
            makeCurrentFragment(mapFragment,R.id.fragment)
        }
        else if(check == 2) {
            makeCurrentFragment(historyFragment,R.id.fragment)
        }

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.status -> {
                    check = 0
                    makeCurrentFragment(statusFragment,R.id.fragment)
                    //viewpage.currentItem = 0
                }
                R.id.lightningmap -> {
                    check = 1
                    makeCurrentFragment(mapFragment,R.id.fragment)
                    //viewpage.currentItem = 1
                }
                R.id.history -> {
                    check = 2
                    makeCurrentFragment(historyFragment,R.id.fragment)
                    //viewpage.currentItem = 2
                }
            }
            true
        }

//        viewpage.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                when(position) {
//                    0 -> {
//                        bottom_navigation.menu.findItem(R.id.status).setChecked(true)
//                    }
//                    1 -> {
//                        bottom_navigation.menu.findItem(R.id.lightningmap).setChecked(true)
//                    }
//
//                    2 -> {
//                        bottom_navigation.menu.findItem(R.id.history).setChecked(true)
//                    }
//                }
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//        })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // find more location button
        extendBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2, Location()).addToBackStack("Location")
                commit()
            }
        }
    }

    private fun makeCurrentFragment(fragment: Fragment, frameId: Int) =
        fragmentManager?.beginTransaction()?.apply {
            replace(frameId, fragment)
            commit()
        }

}