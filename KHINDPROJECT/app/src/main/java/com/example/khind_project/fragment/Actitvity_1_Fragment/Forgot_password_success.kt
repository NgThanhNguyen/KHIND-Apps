package com.example.khind_project.fragment.Actitvity_1_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.khind_project.R

class Forgot_password_success : Fragment() {
    private lateinit var backBtn: Button
    private lateinit var backtoLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_send_mail, container, false)
        backBtn = view.findViewById(R.id.back_button)
        backtoLogin = view.findViewById(R.id.confirm_button)

        backBtn.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Forgot Password", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }

        backtoLogin.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Login", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }

        return view
    }
}