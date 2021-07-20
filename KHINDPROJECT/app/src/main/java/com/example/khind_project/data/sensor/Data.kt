package com.example.khind_project.data.sensor

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("alarm")
    val alarm: String,

    @SerializedName("display_name")
    val display_name: String,

    @SerializedName("id")
    val id: String
)