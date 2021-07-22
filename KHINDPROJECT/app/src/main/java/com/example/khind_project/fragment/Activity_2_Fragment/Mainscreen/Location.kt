package com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentManager
import com.example.khind_project.R
import org.w3c.dom.Text

class Location : Fragment() {
    lateinit var expandBtn: Button
    lateinit var listViewLocation: ListView
    lateinit var Filter: EditText
    var i: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expandBtn = view.findViewById(R.id.expand)
        listViewLocation = view.findViewById(R.id.list_location)
        Filter = view.findViewById(R.id.filter)

        val list = mutableListOf<LocationModel>()
        val filter_list = mutableListOf<LocationModel>()
        list.add(LocationModel("Admiralty Secondary School"))
        list.add(LocationModel("Ahmad Ibrahim Secondary School"))
        list.add(LocationModel("Anderson Secondary School"))
        list.add(LocationModel("Anglican High School"))
        list.add(LocationModel("Anglo-Chinese School"))
        list.add(LocationModel("Methodist Girls' School"))
        list.add(LocationModel("Anglo-Chinese School"))
        list.add(LocationModel("Ang Mo Kio Secondary School"))
        list.add(LocationModel("Assumption English School"))
        val adapt = LocationAdapter(requireContext(),R.layout.row_location,list)
        listViewLocation.adapter = adapt

        Filter.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var textlength = Filter.text.length
                val list_length = list.size - 1
                filter_list.clear()
                for (i in 0 until list_length) {
                    if(textlength <= list[i].location.length) {
                        val s2 = Filter.text.toString()
                        if(list[i].location.toString().contains(s2)) {
                            filter_list.add(LocationModel(list[i].location))
                        }
                    }
                }
                listViewLocation.adapter = LocationAdapter(requireContext(),R.layout.row_location,filter_list)
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        expandBtn.setOnClickListener {
            if(fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager?.popBackStack("Home", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }
}