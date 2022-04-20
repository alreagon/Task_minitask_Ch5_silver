package com.example.chapter_5_allminitask.topic2.model


import com.google.gson.annotations.SerializedName

data class LoginResponseItem(
    @SerializedName("createdAt")
    val createdAt : String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id : String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("role")
    val role : String?,
    @SerializedName("updateAt")
    val updateAt : String?
)