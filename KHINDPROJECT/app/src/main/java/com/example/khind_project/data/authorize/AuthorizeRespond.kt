package com.example.khind_project.data.authorize

import com.google.gson.annotations.SerializedName

data class AuthorizeRespond(
    @SerializedName("data")
    val data: Data,

    @SerializedName("status")
    val status: Boolean
)