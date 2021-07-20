package com.example.khind_project.data.authorize

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("company")
    val company: Company,

    @SerializedName("email")
    val email: String,

    @SerializedName("id")
    val id: String,

    @SerializedName("token")
    val token: Token
)