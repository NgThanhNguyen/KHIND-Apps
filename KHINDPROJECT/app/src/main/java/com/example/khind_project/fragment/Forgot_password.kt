package com.example.khind_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.khind_project.R

class Forgot_password : Fragment() {
    private lateinit var backBtn: Button
    private lateinit var resetBtn: Button
    private lateinit var email: EditText
    val check: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.resetpassword_fragment, container, false)
        backBtn = view.findViewById(R.id.backbutton)
        resetBtn = view.findViewById(R.id.resetBtn)
        email = view.findViewById(R.id.emailreset)

        backBtn.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Login", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }

        resetBtn.setOnClickListener {
            if(email.text.toString().isEmpty()) {
                Toast.makeText(this.context,"Please enter your email",Toast.LENGTH_LONG).show()
            }
            else {
                val fragment = Forgot_password_success()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.fragmentContainer, fragment)?.addToBackStack("Forgot Password")?.commit()
            }
        }

        return view
    }
}