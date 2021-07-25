package com.example.khind_project.fragment.Activity_2_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import com.example.khind_project.R
import kotlinx.android.synthetic.main.fragment_setting.*
import kotlinx.android.synthetic.main.toolbar.*

class Setting : Fragment() {
    lateinit var slideSwitch: SwitchCompat
    lateinit var ringtone: Button
    lateinit var faqButton: Button
    lateinit var privacyButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.nav_bar?.visibility = View.GONE
        activity?.location_constraint?.visibility = View.GONE

        slideSwitch = view.findViewById(R.id.switch_sound)
        faqButton = view.findViewById(R.id.faq_button)
        privacyButton = view.findViewById(R.id.privacy_button)

        slideSwitch.setOnClickListener {
            if(slideSwitch.isChecked) {
                activity?.item3?.visibility = View.VISIBLE
            }
            else {
                activity?.item3?.visibility = View.GONE
            }
        }

        faqButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2,FAQ())
                addToBackStack("FAQ")
                commit()
            }
        }

        privacyButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2,Privacy())
                addToBackStack("Privacy")
                commit()
            }
        }
    }
}