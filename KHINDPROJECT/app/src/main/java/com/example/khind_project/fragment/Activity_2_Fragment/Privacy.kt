package com.example.khind_project.fragment.Activity_2_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.khind_project.R
import kotlinx.android.synthetic.main.fragment_f_a_q.*
import kotlinx.android.synthetic.main.toolbar.*

class Privacy : Fragment() {
    lateinit var privacyBack: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_a_q, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.toolbar?.visibility = View.GONE
        activity?.nav_bar?.visibility = View.GONE
        activity?.location_constraint?.visibility = View.GONE
        activity?.titles?.text = "Privacy"
        privacyBack = view.findViewById(R.id.backbutton_faq)

        privacyBack.setOnClickListener {
            activity?.toolbar?.visibility = View.VISIBLE
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Privacy", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}