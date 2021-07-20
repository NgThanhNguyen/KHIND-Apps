package com.example.khind_project.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.khind_project.R
import com.example.khind_project.repos.PASSWORD
import com.example.khind_project.repos.PREFERENCE_NAME
import com.example.khind_project.repos.SharePrefRepository
import com.example.khind_project.repos.USERNAME
import com.example.khind_project.viewmodels.ActivityViewModels
import kotlinx.android.synthetic.main.login_fragment.*

class Login : Fragment() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var btnLogin: Button
    private lateinit var fpass: TextView
    private val SharePrefRepository by lazy { SharePrefRepository(requireContext()) }
    private lateinit var signInViewModel: ActivityViewModels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signInViewModel = ViewModelProvider(this).get(ActivityViewModels::class.java)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.login_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        username = view.findViewById(R.id.emailBar)
        password = view.findViewById(R.id.passwordBar)
        btnLogin = view.findViewById(R.id.loginBtn)
        fpass = view.findViewById(R.id.forgotpass)


        // Click at Login button
        btnLogin.setOnClickListener {
            signInViewModel.signIn(username = username.text.toString(),pass = password.text.toString())!!.observe(viewLifecycleOwner, Observer {
                if(it.status) {
                    Toast.makeText(this.context, "Log in successfully", Toast.LENGTH_LONG).show()
                    SharePrefRepository.putToken(it.data.token.token_id,it.data.token.refresh_token)
                    val transaction = fragmentManager?.beginTransaction()?.apply {
                        replace(R.id.fragmentContainer, Login_screen())
                        commit()
                    }
                }
                else {
                    Toast.makeText(this.context,"The username or password is incorrect",Toast.LENGTH_LONG).show()
                }
            })
        }

        // change to forgot password fragment
        fpass.setOnClickListener {
            val fragment = Forgot_password()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainer,fragment)?.addToBackStack("Login")?.commit()
        }
    }
}