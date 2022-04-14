package com.example.chapter_5_allminitask.topic2


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

//serializable ini fungsinya untuk cmn buat apabila kita ingin beda mama method nya
@Parcelize
data class GetAllCarResponseItem(
    val category: String,
    val createdAt: String,
    val finishRentAt: String,
    val id: Int,
    val image: String,
    val name: String,
    val price: Int,
    val startRentAt: String,
    val status: Boolean,
    val updatedAt: String
) : Parcelable