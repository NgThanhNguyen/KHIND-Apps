package com.example.khind_project.fragment.Activity_2_Fragment.Notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.khind_project.MyViewPagerAdapter
import com.example.khind_project.R
import com.example.khind_project.fragment.Activity_2_Fragment.Notification.alert.Alert
import com.example.khind_project.fragment.Activity_2_Fragment.Notification.message.Message
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.toolbar.*

class Notification : Fragment() {
    lateinit var backBtn: Button
    lateinit var viewPage: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_notification, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar?.visibility = View.GONE
        activity?.nav_bar?.visibility = View.GONE
        activity?.location_constraint?.visibility = View.GONE

        backBtn = view.findViewById(R.id.backbutton1)
        viewPage = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabs)

        val adapterViewPager = MyViewPagerAdapter(requireFragmentManager())
        adapterViewPager.addFragment(Message(),"Messages")
        adapterViewPager.addFragment(Alert(),"Alerts")
        viewPage.adapter = adapterViewPager
        tabLayout.setupWithViewPager(viewPage)


        backBtn.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Notification", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val adapterViewPager = MyViewPagerAdapter(requireFragmentManager())
        adapterViewPager.addFragment(Message(),"Messages")
        adapterViewPager.addFragment(Alert(),"Alerts")
        viewPage.adapter = adapterViewPager
        tabLayout.setupWithViewPager(viewPage)


        backBtn.setOnClickListener {
            activity?.toolbar?.visibility = View.VISIBLE
            activity?.nav_bar?.visibility = View.VISIBLE
            activity?.location_constraint?.visibility = View.VISIBLE
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Notification", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}