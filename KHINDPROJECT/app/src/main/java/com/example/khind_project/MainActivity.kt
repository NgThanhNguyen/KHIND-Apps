package com.example.khind_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.khind_project.fragment.Actitvity_1_Fragment.Splash
import com.example.khind_project.fragment.NavigationDrawer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragmentToActivity(supportFragmentManager, Splash(),R.id.fragmentContainer)
        //addFragmentToActivity(supportFragmentManager,NavigationDrawer(),R.id.fragmentContainer)


    }

    private fun addFragmentToActivity(manager: FragmentManager, fragment: Fragment?, frameId: Int) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        if (fragment != null) {
            transaction.add(frameId, fragment)
        }
        transaction.commit()
    }

/*    private fun replaceFragment(manager: FragmentManager, fragment: Fragment?, frameId: Int) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        if(fragment != null) {
            transaction.replace(frameId, fragment)
        }
        transaction.commit()
    }*/
}