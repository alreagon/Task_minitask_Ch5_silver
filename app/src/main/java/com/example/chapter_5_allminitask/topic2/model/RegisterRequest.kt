package com.example.chapter_5_allminitask.topic2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class RegisterRequest(
    val email : String? = null,
    val password : String? = null,
    val role : String? = null
) : Parcelable
