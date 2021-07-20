package com.example.khind_project.data.sensor

import com.google.gson.annotations.SerializedName

data class SensorRespond(
    @SerializedName("data")
    val data: List<Data>,

    @SerializedName("status")
    val status: Boolean
)