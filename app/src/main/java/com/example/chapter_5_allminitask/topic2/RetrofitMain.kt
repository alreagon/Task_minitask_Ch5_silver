package com.example.chapter_5_allminitask.topic2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter_5_allminitask.databinding.ActivityRetrofitMainBinding
import com.example.chapter_5_allminitask.topic2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitMain : AppCompatActivity() {
    private lateinit var binding: ActivityRetrofitMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchAllData()
        setupView()
    }

    private fun setupView() {
        binding.floatingButton.setOnClickListener {
        }
    }

    private fun fetchAllData() {
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<GetAllCarResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    val body = response.body()
                    val code = response.code()
                    if (code == 200) {
                        showList(body)
                        binding.pbLoading.visibility = View.GONE
                    } else {
                        binding.pbLoading.visibility = View.GONE
                    }
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                    binding.pbLoading.visibility = View.GONE
                }
            })
    }

    private fun showList(data: List<GetAllCarResponseItem>?) {
        val adapter = AdapterTopic2(object : AdapterTopic2.OnClickListener {
            override fun onClickItem(data: GetAllCarResponseItem) {
            }
        })
        adapter.submitData(data)
        binding.RecyclerViewRetrofit.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.RecyclerViewRetrofit.adapter = adapter

    }

}