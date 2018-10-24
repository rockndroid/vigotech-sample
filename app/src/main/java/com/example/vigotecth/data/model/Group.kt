package com.example.vigotecth.data.model

import com.google.gson.annotations.SerializedName

data class Group (
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("url") val url: String
)