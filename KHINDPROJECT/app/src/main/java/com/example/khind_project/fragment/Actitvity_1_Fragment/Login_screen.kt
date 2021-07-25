package com.example.khind_project.fragment.Actitvity_1_Fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.khind_project.R
import com.example.khind_project.SecondActivity
import com.example.khind_project.repos.SharePrefRepository
import com.example.khind_project.viewmodels.ActivityViewModels

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
        SensorViewModel.getInfo(SharePrefRepository.getToken())

        SensorViewModel.getSensorInfo()?.observe(viewLifecycleOwner, {
            if(it.status) {
                SharePrefRepository.putAlarm(it.data[0].alarm)
                SharePrefRepository.putSensorId(it.data[0].id)
                activity?.let {
                    val intent = Intent(it,SecondActivity::class.java)
                    it.startActivity(intent)
                }

//                SensorViewModel.getData(SharePrefRepository.getToken(),SharePrefRepository.getSensorId())
//
//                SensorViewModel.getSensorData()?.observe(viewLifecycleOwner, {
//                    if(it.status) {
//                        SharePrefRepository.putLongitude(it.data.longitude.toFloat())
//                        SharePrefRepository.putLatitude(it.data.latitude.toFloat())
//                    }
//                })
            }
            else {
                Toast.makeText(this.context,"Failed to get sensor info", Toast.LENGTH_LONG).show()
            }
        })
    }
}