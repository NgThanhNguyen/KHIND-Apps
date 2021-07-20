package com.example.khind_project.repos

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import com.example.khind_project.api.ApiRequest
import com.example.khind_project.data.authorize.AuthorizeRespond
import com.example.khind_project.data.refresh.RefreshRespond
import com.example.khind_project.data.sensor.SensorRespond
import com.example.khind_project.data.sensordetail.SensorDetailRespond
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {

}