package com.example.khind_project.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.example.khind_project.R
import kotlinx.android.synthetic.main.fragment_notification.*
import org.w3c.dom.Text

class Notification : Fragment() {
    lateinit var backBtn: Button
    lateinit var mess: TextView
    lateinit var alert: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_notification, container, false)
        backBtn = view.findViewById(R.id.backbutton1)
        mess = view.findViewById(R.id.message)
        alert = view.findViewById(R.id.alert)

        backBtn.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Home", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }

        mess.setOnClickListener {
            this.bar1.visibility = View.VISIBLE
            this.bar2.visibility = View.GONE
        }

        alert.setOnClickListener {
            this.bar1.visibility = View.GONE
            this.bar2.visibility = View.VISIBLE
        }


        return view
    }

}