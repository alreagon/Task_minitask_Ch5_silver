package com.example.chapter_5_allminitask.topic3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


// TODO 1: Buat sebuah class viewModel dengan function lengkap
class MainViewModel2 : ViewModel() {
    val vCounnter: MutableLiveData<Int> = MutableLiveData(0)

    fun incrementCount() {
        vCounnter.postValue(vCounnter.value?.plus(1))
    }

    fun decrementCount() {
        vCounnter.value?.let {
            if (it > 0) {
                vCounnter.postValue(vCounnter.value?.minus(1))
            }
        }
    }
}