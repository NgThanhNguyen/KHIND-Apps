package com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.history

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.khind_project.R

class HistoryAdapter(val mycontext: Context, val resources: Int, val item: List<HistoryModel>): ArrayAdapter<HistoryModel>(mycontext,resources,item) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mycontext)
        val view: View = layoutInflater.inflate(resources,null)
        val time: TextView = view.findViewById(R.id.timer)
        val warning: TextView = view.findViewById(R.id.warn)
        val message: TextView = view.findViewById(R.id.mess)
        val myItem: HistoryModel = item[position]
        time.text = myItem.time
        warning.text = myItem.warning
        message.text = myItem.message
        return view
    }
}