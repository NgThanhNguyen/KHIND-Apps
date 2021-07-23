package com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.status

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.khind_project.R
import com.example.khind_project.repos.SharePrefRepository

class Status : Fragment() {
    lateinit var title_text: TextView
    private val SharePrefRepository by lazy { SharePrefRepository(requireContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title_text = view.findViewById(R.id.text_title)
        if (SharePrefRepository.getAlarm() == "clear") {
            makeCurrentFragment(Green())
            title_text.setTextColor(Color.parseColor("#9DD31C"))
            title_text.setBackgroundResource(R.drawable.rounded_rectangle_green)

        }
        else if(SharePrefRepository.getAlarm() == "alert") {
            makeCurrentFragment(Red())
            title_text.setTextColor(Color.parseColor("#FF0000"))
            title_text.setBackgroundResource(R.drawable.rounded_rectangle_red)
        }
        else {
            makeCurrentFragment(Orange())
            title_text.setTextColor(Color.parseColor("#FE9700"))
            title_text.setBackgroundResource(R.drawable.rounded_rectangle_orange)
        }
    }

    override fun onResume() {
        super.onResume()
        if (SharePrefRepository.getAlarm() == "clear") {
            makeCurrentFragment(Green())
            title_text.setTextColor(Color.parseColor("#9DD31C"))
            title_text.setBackgroundResource(R.drawable.rounded_rectangle_green)

        }
        else if(SharePrefRepository.getAlarm() == "alert") {
            makeCurrentFragment(Red())
            title_text.setTextColor(Color.parseColor("#FF0000"))
            title_text.setBackgroundResource(R.drawable.rounded_rectangle_red)
        }
        else {
            makeCurrentFragment(Orange())
            title_text.setTextColor(Color.parseColor("#FE9700"))
            title_text.setBackgroundResource(R.drawable.rounded_rectangle_orange)
        }
    }


    private fun makeCurrentFragment(fragment: Fragment) =
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.imagecontainer, fragment)
            commit()
        }

}