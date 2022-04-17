package com.example.chapter_5_allminitask.topic2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostRegisterResponse(
    val createdAt: String? = null,
    val email: String? = null,
    val id : Int? = null,
    val password : String? = null,
    val role : String? = null,
    val updateAt: String? = null
) :Parcelable
