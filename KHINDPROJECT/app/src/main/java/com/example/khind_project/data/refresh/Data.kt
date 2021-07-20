package com.example.khind_project.data.refresh

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("token")
    val token: Token
)