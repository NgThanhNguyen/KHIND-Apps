package com.example.khind_project.fragment.Activity_2_Fragment.Mainscreen.status

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.khind_project.R
import com.example.khind_project.repos.SharePrefRepository
import com.example.khind_project.viewmodels.ActivityViewModels

class Status : Fragment() {
    private lateinit var title_text: TextView
    lateinit var image: ImageView
    private val SharePrefRepository by lazy { SharePrefRepository(requireContext()) }
    private lateinit var sensorViewModel: ActivityViewModels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorViewModel = ViewModelProvider(this).get(ActivityViewModels::class.java)

        sensorViewModel.getInfo(SharePrefRepository.getToken())

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title_text = view.findViewById(R.id.text_title)
        image = view.findViewById(R.id.imagecontainer)

        sensorViewModel.getSensorInfo()?.observe(viewLifecycleOwner,{
            if(it.status) {
                if(it.data[0].alarm == "alert") {
                    image.setBackgroundResource(R.drawable.ic_group_2)
                    title_text.setTextColor(Color.parseColor("#FF0000"))
                    title_text.setBackgroundResource(R.drawable.rounded_rectangle_red)

                }
                else if(it.data[0].alarm == "clear") {
                    image.setBackgroundResource(R.drawable.clear)
                    title_text.setTextColor(Color.parseColor("#9DD31C"))
                    title_text.setBackgroundResource(R.drawable.rounded_rectangle_green)
                }
                else {
                    image.setBackgroundResource(R.drawable.warning)
                    title_text.setTextColor(Color.parseColor("#FE9700"))
                    title_text.setBackgroundResource(R.drawable.rounded_rectangle_orange)
                }
            }
            else {
                sensorViewModel.Refresh(SharePrefRepository.getToken(),SharePrefRepository.getRefeshToken())
            }
        })
    }



    private fun makeCurrentFragment(fragment: Fragment) =
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.imagecontainer, fragment)
            commit()
        }

}