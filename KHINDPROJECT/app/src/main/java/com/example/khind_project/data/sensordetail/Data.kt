package com.example.khind_project.data.sensordetail

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("alarm")
    val alarm: String,
    @SerializedName("display_name")
    val display_name: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("installation_address")
    val installation_address: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("z1r")
    val z1r: Int,
    @SerializedName("z2r")
    val z2r: Int
)