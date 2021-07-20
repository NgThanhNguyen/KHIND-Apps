package com.example.khind_project.api

import com.example.khind_project.data.authorize.AuthorizeRespond
import com.example.khind_project.data.refresh.RefreshRespond
import com.example.khind_project.data.sensor.SensorRespond
import com.example.khind_project.data.sensordetail.SensorDetailRespond
import retrofit2.Call
import retrofit2.http.*

interface ApiRequest {
    @POST("/auth/sign_in")
    fun getAuthorize(@Query("email") email: String,
                     @Query("password") pass: String

    ): Call<AuthorizeRespond>

    @POST("/auth/refresh_token")
    fun reFresh(@Query("X-Refresh-Token") Token: String,
                @Query("refresh_token") refreshToken: String

    ): Call<RefreshRespond>

    @GET("/sensors")
    fun getSensor(@Query("page") Page: Int = 1,
                  @Header("X-Http-Token") token: String

    ): Call<SensorRespond>

    @GET("/sensors/{id}")
    fun getSensorDetail(@Header("X-Http-Token") token: String,
                        @Path("id") id: String

    ): Call<SensorDetailRespond>
}