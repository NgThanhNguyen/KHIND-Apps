package com.example.khind_project

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.Home
import com.example.khind_project.viewmodels.ActivityViewModels

class SecondActivity : AppCompatActivity() {
    //private lateinit var SensorDataViewModel: ActivityViewModels
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        addFragmentToActivity(supportFragmentManager, Home(),R.id.fragmentContainer2)
    }

    private fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment?, frameId: Int) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        if (fragment != null) {
            transaction.add(frameId, fragment)
        }
        transaction.commit()
    }
}