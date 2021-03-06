package com.example.khind_project.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.khind_project.R
import com.example.khind_project.SecondActivity
import com.example.khind_project.repos.DataRepository
import com.example.khind_project.repos.SharePrefRepository
import com.example.khind_project.viewmodels.ActivityViewModels
import java.util.*

class Login_screen : Fragment() {
    private val SharePrefRepository by lazy { SharePrefRepository(requireContext()) }

    private lateinit var SensorViewModel: ActivityViewModels
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SensorViewModel = ViewModelProvider(this).get(ActivityViewModels::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        val view: View =  inflater.inflate(R.layout.fragment_backgound_success_login, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val handle = Handler()
        SensorViewModel.getSensorInfo(SharePrefRepository.getToken())?.observe(viewLifecycleOwner, {
            if(it.status) {
                activity?.let {
                    val intent = Intent(it,SecondActivity::class.java)
                    it.startActivity(intent)
                }
            }
            else {
                Toast.makeText(this.context,"Failed to get sensor info", Toast.LENGTH_LONG).show()
            }
        })
    }
}