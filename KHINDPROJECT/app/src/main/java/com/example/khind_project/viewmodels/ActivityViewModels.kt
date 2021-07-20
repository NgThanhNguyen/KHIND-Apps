package com.example.khind_project.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.khind_project.api.ApiRequest
import com.example.khind_project.data.authorize.AuthorizeRespond
import com.example.khind_project.data.refresh.RefreshRespond
import com.example.khind_project.data.sensor.SensorRespond
import com.example.khind_project.data.sensordetail.SensorDetailRespond
import com.example.khind_project.repos.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityViewModels(): ViewModel() {
    var authorizeViewModel: MutableLiveData<AuthorizeRespond>? = MutableLiveData<AuthorizeRespond>()
    var refreshViewModel: MutableLiveData<RefreshRespond>? = MutableLiveData<RefreshRespond>()
    var sensorViewModel: MutableLiveData<SensorRespond>? = MutableLiveData<SensorRespond>()
    var sensorDetailViewModel: MutableLiveData<SensorDetailRespond>? = MutableLiveData<SensorDetailRespond>()

    fun init(): ApiRequest {
        return Retrofit.Builder()
            .baseUrl("https://khind.vinova.sg/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)
    }

    fun getToken(email: String, password: String) {
        val data = init()
        data.getAuthorize(email = email, pass = password).enqueue(object:
            Callback<AuthorizeRespond> {
            override fun onResponse(
                call: Call<AuthorizeRespond>,
                response: Response<AuthorizeRespond>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        authorizeViewModel?.value = AuthorizeRespond(responseBody.data,responseBody.status)
                        Log.d("Authorize", "Token: ${responseBody.data.token.token_id}")
                        //Log.d("Repository", "id: ${responseBody.data.id}")
                    } else {
                        Log.d("Repository", "Failed to get response 1")
                        //onError.invoke(response.message())
                    }
                } else {
                    Log.d("Repository", "Failed to get response 2")
                    //onError.invoke(response.message())
                }
            }

            override fun onFailure(call: Call<AuthorizeRespond>, t: Throwable) {
                Log.e("Repository", "onFailure", t)
                //onError.invoke(t.message.toString())
            }
        })
    }

    fun Refresh(token: String, refresh_token: String) {
        val data = init()
        data.reFresh(Token = token, refreshToken = refresh_token).enqueue(object: Callback<RefreshRespond> {
            override fun onResponse(
                call: Call<RefreshRespond>,
                response: Response<RefreshRespond>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()

                    if (responseBody != null) {
                        refreshViewModel?.value = RefreshRespond(responseBody.data,responseBody.status)
                        Log.d("Refresh", "Token: ${responseBody.data.token.new_token}")
                        Log.d("Refresh", "Token: ${responseBody.data.token.new_refresh_token}")
                        //Log.d("Repository", "id: ${responseBody.data.id}")
                    } else {
                        Log.d("Repository", "Failed to get response")
                        //onError.invoke(response.message())
                    }
                } else {
                    Log.d("Repository", "Failed to get response")
                    //onError.invoke(response.message())
                }
            }

            override fun onFailure(call: Call<RefreshRespond>, t: Throwable) {
                Log.e("Repository", "onFailure", t)
                //onError.invoke(t.message.toString())
            }
        })
    }

    fun getInfo(token_id: String) {
        val data = init()
        data.getSensor(token = token_id).enqueue(object: Callback<SensorRespond> {
            override fun onResponse(
                call: Call<SensorRespond>,
                response: Response<SensorRespond>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()

                    if (responseBody != null) {
                        sensorViewModel?.value = SensorRespond(responseBody.data,responseBody.status)
                        Log.d("Sensor", "Sensor_id: ${responseBody.data[0].id}")
                        //Log.d("Repository", "id: ${responseBody.data[0].alarm}")
                    } else {
                        Log.d("Repository", "Failed to get response 1")
                        //onError.invoke(response.message())
                    }
                } else {
                    Log.d("Sensor", "Failed to get response 2")
                    //onError.invoke(response.message())
                }
            }

            override fun onFailure(call: Call<SensorRespond>, t: Throwable) {
                Log.e("Repository", "onFailure", t)
                //onError.invoke(t.message.toString())
            }
        })
    }

    fun getData(token_id: String, id: String) {
        val data = init()
        data.getSensorDetail(token = token_id, id = id).enqueue(object: Callback<SensorDetailRespond> {
            override fun onResponse(
                call: Call<SensorDetailRespond>,
                response: Response<SensorDetailRespond>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()

                    if (responseBody != null) {
                        sensorDetailViewModel?.value = SensorDetailRespond(responseBody.data,responseBody.status)
                        Log.d("Data", "Alarm: ${responseBody.data.alarm}")
                        Log.d("Data", "Name: ${responseBody.data.display_name}")
                        //onSuccess.invoke(responseBody.respond.Articles)
                    } else {
                        Log.d("Repository", "Failed to get response")
                        //onError.invoke(response.message())
                    }
                } else {
                    Log.d("Repository", "Failed to get response")
                    //onError.invoke(response.message())
                }
            }

            override fun onFailure(call: Call<SensorDetailRespond>, t: Throwable) {
                Log.e("Repository", "onFailure", t)
                //onError.invoke(t.message.toString())
            }
        })
    }

    fun signIn(username: String, pass: String): LiveData<AuthorizeRespond>? {
    getToken(username,pass)
    return authorizeViewModel
    }

    fun refresh(Token: String, RefreshToken: String): LiveData<RefreshRespond>? {
        Refresh(Token,RefreshToken)
        return refreshViewModel
    }

    fun getSensorInfo(Token: String): LiveData<SensorRespond>? {
        getInfo(Token)
        return sensorViewModel
    }

    fun getSensorData(Token: String, ID: String): LiveData<SensorDetailRespond>? {
        getData(Token, ID)
        return sensorDetailViewModel
    }
}