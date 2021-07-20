package com.example.khind_project.data.refresh

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("refresh_token")
    val new_refresh_token: String,

    @SerializedName("token")
    val new_token: String
)