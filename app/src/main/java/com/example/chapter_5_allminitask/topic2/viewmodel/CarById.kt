package com.example.chapter_5_allminitask.topic2.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chapter_5_allminitask.topic2.model.GetAllCarResponseItem
import com.example.chapter_5_allminitask.topic2.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class CarById : ViewModel() {

    private val carbyId = MutableLiveData<GetAllCarResponseItem?>()
    fun getCarById(id: Int): MutableLiveData<GetAllCarResponseItem?>{
        setDataCarById(id)
        return carbyId
    }

    fun setDataCarById(id:Int){
        ApiClient.instance.getCarById(id)
            .enqueue(object : Callback<GetAllCarResponseItem>{
                override fun onResponse(
                    call: Call<GetAllCarResponseItem>,
                    response: Response<GetAllCarResponseItem>
                ) {

                    val body = response.body()
                    val code = response.code()
                    if (code == 200){
                        carbyId.postValue(body)
                    }else{

                    }
                }

                override fun onFailure(call: Call<GetAllCarResponseItem>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

}

