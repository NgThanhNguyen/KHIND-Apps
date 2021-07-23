package com.example.khind_project.fragment.Activity_2_Fragment.Notification.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.khind_project.R

class Message : Fragment() {
    private lateinit var listViewMessage: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listViewMessage = view.findViewById(R.id.list_message)

        val List_message = mutableListOf<MessageModel>()
        List_message.add(MessageModel("04 Sep, 11:08AM","BROADCAST MESSAGE TITLE","Push notification message here is very long..."))
        listViewMessage.adapter = MessageAdapter(requireContext(),R.layout.row_message,List_message)
    }

    override fun onResume() {
        super.onResume()
    }
}