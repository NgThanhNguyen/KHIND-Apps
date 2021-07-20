package com.example.khind_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.khind_project.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*

class Home : Fragment() {
    lateinit var bottom_navigation: BottomNavigationView
    lateinit var notficationBtn: Button
    lateinit var extendBtn: Button
    lateinit var viewpage: ViewPager

//    class MyViewPagerAdapter(manager: FragmentManager): FragmentStatePagerAdapter(manager) {
//        private val fragmentList: MutableList<Fragment> = ArrayList()
//        private val titleList: MutableList<String> = ArrayList()
//
//        override fun getCount(): Int {
//            return fragmentList.size
//        }
//
//        override fun getItem(position: Int): Fragment {
//            return fragmentList[position]
//        }
//
//        override fun getPageTitle(position: Int): CharSequence? {
//            return titleList[position]
//        }
//
//        fun addFragment(fragment: Fragment) {
//            fragmentList.add(fragment)
//        }
//
//    }

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

        val adapterViewPager = Notification.MyViewPagerAdapter(getChildFragmentManager())
        adapterViewPager.addFragment(statusFragment,"")
        adapterViewPager.addFragment(mapFragment,"")
        adapterViewPager.addFragment(historyFragment,"")
        viewpage.adapter = adapterViewPager

        //makeCurrentFragment(statusFragment)

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
                replace(R.id.fragmentContainer2,Notification()).addToBackStack("Home")
                commit()
            }
        }


        // find more location button
        extendBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2,Location()).addToBackStack("Home")
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