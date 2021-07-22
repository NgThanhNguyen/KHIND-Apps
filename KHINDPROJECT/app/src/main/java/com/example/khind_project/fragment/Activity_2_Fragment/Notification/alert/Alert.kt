package com.example.khind_project.fragment.Activity_2_Fragment.Notification.alert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.khind_project.R
import com.example.khind_project.fragment.Activity_2_Fragment.Notification.Details
import com.example.khind_project.fragment.Activity_2_Fragment.Notification.message.MessageModel

class Alert : Fragment() {
    lateinit var detailBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alert, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listViewAlert = view.findViewById<ListView>(R.id.list_alert)
        val List = mutableListOf<AlertModel>()
        List.add(AlertModel("04 Sep, 11:08AM","BROADCAST MESSAGE TITLE","Push notification message here is very long..."))
        List.add(AlertModel("04 Sep, 11:22AM","BROADCAST MESSAGE TITLE","Push notification message"))
        listViewAlert.adapter = AlertAdapter(requireContext(),R.layout.row_alert,List)

        listViewAlert.isClickable = true

        listViewAlert.setOnItemClickListener { parent, view, position, id ->
            if(position == 0) {
                Toast.makeText(this.context, "Click Item number: $position", Toast.LENGTH_LONG)
                    .show()
            }
            val transaction = fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainer2, Details())
                addToBackStack("Alert")
                commit()
            }
        }
    }
}