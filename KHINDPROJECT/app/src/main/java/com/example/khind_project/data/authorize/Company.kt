package com.example.khind_project.data.authorize

import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("full_name")
    val full_name: String,

    @SerializedName("id")
    val id: String
)