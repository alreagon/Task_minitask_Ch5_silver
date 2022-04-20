package com.example.chapter_5_allminitask.topic2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chapter_5_allminitask.topic2.model.PostRegisterResponse
import com.example.chapter_5_allminitask.topic2.model.RegisterRequest
import com.example.chapter_5_allminitask.topic2.model.RegisterRequestAdd
import com.example.chapter_5_allminitask.topic2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterUser : ViewModel() {
    private val registerUser = MutableLiveData<RegisterRequestAdd?>()

    fun getRegisterUser(email : String, pass : String) : MutableLiveData<RegisterRequestAdd?>{
        registerAction(email, pass)
        return registerUser
    }

    private fun registerAction(email: String,pass: String) {

        val request = RegisterRequest(
            email = email,
            password = pass,
            role = "admin"
        )
        ApiClient.instance.postRegister(request)
            .enqueue(object : Callback<PostRegisterResponse>{
                override fun onResponse(
                    call: Call<PostRegisterResponse>,
                    response: Response<PostRegisterResponse>
                ) {
                    val code = response.code()
                    val body = response.body()
                    registerUser.postValue(RegisterRequestAdd(code, body))
                }

                override fun onFailure(call: Call<PostRegisterResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

    }
}