package com.example.chapter_5_allminitask.topic2.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginRequest (

    @SerializedName("email")
    val email: String?,
    @SerializedName("password")
    val password: String?

) : Parcelable