package com.example.khind_project

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.khind_project.fragment.Home
import com.example.khind_project.repos.DataRepository

class SecondActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        addFragmentToActivity(supportFragmentManager,Home(),R.id.fragmentContainer2)
    }

    private fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment?, frameId: Int) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        if (fragment != null) {
            transaction.add(frameId, fragment)
        }
        transaction.commit()
    }
}