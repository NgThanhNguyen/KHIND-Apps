package com.example.khind_project.fragment.Activity_2_Fragment.Notification.message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.khind_project.R

class MessageAdapter(var mycontext: Context, var resources: Int, var item: List<MessageModel>): ArrayAdapter<MessageModel>(mycontext,resources,item) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mycontext)
        val view: View = layoutInflater.inflate(resources,null)
        val time: TextView = view.findViewById(R.id.time)
        val main_text: TextView = view.findViewById(R.id.mess)
        val sub_text: TextView = view.findViewById(R.id.submess)
        val myItem: MessageModel = item[position]
        time.text = myItem.time
        main_text.text = myItem.main_text
        sub_text.text = myItem.sub_text
        return view
    }
}