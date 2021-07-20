package com.example.khind_project.data.authorize

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("refresh_token")
    val refresh_token: String,

    @SerializedName("token")
    val token_id: String
)