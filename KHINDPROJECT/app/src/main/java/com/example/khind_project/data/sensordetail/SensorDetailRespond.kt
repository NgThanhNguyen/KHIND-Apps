package com.example.khind_project.data.sensordetail

import com.google.gson.annotations.SerializedName

data class SensorDetailRespond(
    @SerializedName("data")
    val data: Data,

    @SerializedName("status")
    val status: Boolean
)