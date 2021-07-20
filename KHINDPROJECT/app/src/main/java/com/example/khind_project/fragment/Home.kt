package com.example.khind_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.khind_project.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*

class Home : Fragment() {
    lateinit var bottom_navigation: BottomNavigationView
    lateinit var notficationBtn: Button

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

        makeCurrentFragment(statusFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.status -> makeCurrentFragment(statusFragment)
                R.id.lightningmap -> makeCurrentFragment(mapFragment)
                R.id.history -> makeCurrentFragment(historyFragment)
            }
            true
        }

        notficationBtn.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2,Notification()).addToBackStack("Home")
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