package com.example.chapter_5_allminitask.topic2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chapter_5_allminitask.topic2.model.GetAllCarResponseItem
import com.example.chapter_5_allminitask.topic2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllCar : ViewModel() {

    val allCar = MutableLiveData<List<GetAllCarResponseItem>>()
    fun getCar() : MutableLiveData<List<GetAllCarResponseItem>>{
        setAllDataCar()
        return allCar
    }

    fun setAllDataCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<GetAllCarResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    val body = response.body()
                    val code = response.code()
                    if (code == 200){
                        allCar.postValue(body)
                    }else{

                    }
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {

                }

            })
    }

}