package com.example.chapter_5_allminitask.topic2.network

import com.example.chapter_5_allminitask.topic2.model.GetAllCarResponseItem
import com.example.chapter_5_allminitask.topic2.model.PostRegisterResponse
import com.example.chapter_5_allminitask.topic2.model.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    //GET digunakan untuk memanggil semua data yang terdapat pada server
    @GET("admin/car")
    fun getAllCar(): Call<List<GetAllCarResponseItem>>

    @POST("admin/auth/register")
    fun postRegister(@Body request: RegisterRequest) : Call<PostRegisterResponse>
}