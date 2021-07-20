package com.example.khind_project.data.refresh

import com.google.gson.annotations.SerializedName

data class RefreshRespond(
    @SerializedName("data")
    val data: Data,

    @SerializedName("status")
    val status: Boolean
)