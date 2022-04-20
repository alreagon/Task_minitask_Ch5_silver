package com.example.chapter_5_allminitask.topic2.network

import com.example.chapter_5_allminitask.topic2.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    //GET digunakan untuk memanggil semua data yang terdapat pada server
    @GET("admin/car")
    fun getAllCar(): Call<List<GetAllCarResponseItem>>

    //                 v
    @GET("admin/car/{id}") //yg id WAJIB SAMA parameeternya diantara kedua nya (v & ^)
    fun getCarById(@Path("id") carId:Int) : Call<GetAllCarResponseItem>
    //                         ^

    @POST("admin/auth/register")
    fun postRegister(@Body request: RegisterRequest) : Call<PostRegisterResponse>

    @POST("admin/auth/login")
    fun loginUser(@Body request: LoginRequest) : Call<LoginResponseItem>
}