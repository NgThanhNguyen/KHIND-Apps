package com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.khind_project.R

class History : Fragment() {
    lateinit var historyListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyListView = view.findViewById(R.id.list_history_detect)
        val list_history = mutableListOf<HistoryModel>()
        list_history.add(HistoryModel("04 Sep, 11:08AM","LIGHTNING DETECTED","More lightning detected for the last 30 mins"))
        list_history.add(HistoryModel("04 Sep, 11:00AM","LIGHTNING DETECTED","Small lightning detected"))
        list_history.add(HistoryModel("04 Sep, 11:00AM","ALL CLEAR","No lightning detected for the last 30 mins"))
        historyListView.adapter = HistoryAdapter(requireContext(),R.layout.row_history,list_history)
    }

    override fun onResume() {
        super.onResume()

    }
}