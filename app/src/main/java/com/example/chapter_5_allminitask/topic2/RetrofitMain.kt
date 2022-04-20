package com.example.chapter_5_allminitask.topic2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter_5_allminitask.databinding.ActivityRetrofitMainBinding
import com.example.chapter_5_allminitask.topic2.model.GetAllCarResponseItem
import com.example.chapter_5_allminitask.topic2.network.ApiClient
import com.example.chapter_5_allminitask.topic2.viewmodel.AllCar
import com.example.chapter_5_allminitask.topic3.MainViewModel2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitMain : AppCompatActivity() {
    private lateinit var binding: ActivityRetrofitMainBinding
    private val viewModel: AllCar by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAllCar()
//        fetchAllData()
        setupView()
//        getCarDetail(2)
    }

    private fun getAllCar() {
        viewModel.getCar().observe(this, Observer { listCar ->showList(listCar) })
    }

//    private fun getCarDetail(id:Int) {
//        ApiClient.instance.getCarById(id)
//            .enqueue(object : Callback<List<GetAllCarResponseItem>>{
//                override fun onResponse(
//                    call: Call<List<GetAllCarResponseItem>>,
//                    response: Response<List<GetAllCarResponseItem>>
//                ) {
//                    val body = response.body()
//                    val code = response.code()
//                    if (code == 200){
//                        binding.pbLoading.visibility = View.GONE
//                    }else{
//                        binding.pbLoading.visibility = View.GONE
//                    }
//                }
//
//                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
//                    binding.pbLoading.visibility = View.GONE
//                }
//
//            })
//    }

    private fun setupView() {
        binding.floatingButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

//    private fun fetchAllData() {
//        ApiClient.instance.getAllCar()
//            .enqueue(object : Callback<List<GetAllCarResponseItem>> {
//                override fun onResponse(
//                    call: Call<List<GetAllCarResponseItem>>,
//                    response: Response<List<GetAllCarResponseItem>>
//                ) {
//                    val body = response.body()
//                    val code = response.code()
//                    if (code == 200) {
//                        showList(body)
//                        binding.pbLoading.visibility = View.GONE
//                    } else {
//                        binding.pbLoading.visibility = View.GONE
//                    }
//                }
//
//                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
//                    binding.pbLoading.visibility = View.GONE
//                }
//            })
//    }

    private fun showList(data: List<GetAllCarResponseItem>?) {
        val adapter = AdapterTopic2(object : AdapterTopic2.OnClickListener {
            override fun onClickItem(data: GetAllCarResponseItem) {

                Toast.makeText(this@RetrofitMain, "Test ${data.id}",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RetrofitMain, DetailCar::class.java)
                intent.putExtra("ID_KEY",data.id)
                startActivity(intent)
                //TODO: MEMBUKA AKTIVITY BARU DAN MENAMPILKAN DETAIL
            }
        })
        adapter.submitData(data)
        binding.RecyclerViewRetrofit.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.RecyclerViewRetrofit.adapter = adapter
        binding.pbLoading.visibility = View.GONE
    }


}