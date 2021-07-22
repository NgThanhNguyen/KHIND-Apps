package com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.khind_project.R

class LocationAdapter(val mycontext: Context, var resources: Int, var item: List<LocationModel>): ArrayAdapter<LocationModel>(mycontext,resources,item) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mycontext)
        val view: View = layoutInflater.inflate(resources,null)
        val place: TextView = view.findViewById(R.id.locate)
        val myItem: LocationModel = item[position]
        place.text = myItem.location
        return view
    }
}