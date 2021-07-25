package com.example.khind_project.fragment.Activity_2_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.khind_project.R
import kotlinx.android.synthetic.main.toolbar.*

class About : Fragment() {
    lateinit var backAbout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar?.visibility = View.GONE
        activity?.nav_bar?.visibility = View.GONE
        activity?.location_constraint?.visibility = View.GONE

        backAbout = view.findViewById(R.id.btnbackabout)

        backAbout.setOnClickListener {
            activity?.toolbar?.visibility = View.VISIBLE
            activity?.nav_bar?.visibility = View.VISIBLE
            activity?.location_constraint?.visibility = View.VISIBLE
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Support", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }

    }
}