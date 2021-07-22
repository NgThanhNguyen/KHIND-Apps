package com.example.khind_project.fragment.Activity_2_Fragment.Notification.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.khind_project.R

class AlertAdapter(var mycontext: Context, var resources: Int, var item: List<AlertModel>): ArrayAdapter<AlertModel>(mycontext,resources,item) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mycontext)
        val view: View = layoutInflater.inflate(resources,null)
        val time: TextView = view.findViewById(R.id.time1)
        val main_text: TextView = view.findViewById(R.id.mess1)
        val sub_text: TextView = view.findViewById(R.id.submess1)
        val myItem: AlertModel = item[position]
        time.text = myItem.time
        main_text.text = myItem.main_text
        sub_text.text = myItem.sub_text
        return view
    }
}