package com.example.khind_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.khind_project.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_notification.*
import org.w3c.dom.Text

class Notification : Fragment() {
    lateinit var backBtn: Button
    lateinit var viewPage: ViewPager
    lateinit var tabLayout: TabLayout

    class MyViewPagerAdapter(manager: FragmentManager): FragmentStatePagerAdapter(manager) {
        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

    }

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
        backBtn = view.findViewById(R.id.backbutton1)
        viewPage = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabs)

        val adapterViewPager = MyViewPagerAdapter(getChildFragmentManager())
        adapterViewPager.addFragment(Message(),"Message")
        adapterViewPager.addFragment(Alert(),"Alert")
        viewPage.adapter = adapterViewPager
        tabLayout.setupWithViewPager(viewPage)


        backBtn.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Home", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}