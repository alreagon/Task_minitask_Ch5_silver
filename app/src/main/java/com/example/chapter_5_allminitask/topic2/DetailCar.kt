package com.example.chapter_5_allminitask.topic2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.chapter_5_allminitask.R
import com.example.chapter_5_allminitask.databinding.ActivityDetailCarBinding
import com.example.chapter_5_allminitask.topic2.model.GetAllCarResponseItem
import com.example.chapter_5_allminitask.topic2.viewmodel.AllCar
import com.example.chapter_5_allminitask.topic2.viewmodel.CarById

class DetailCar : AppCompatActivity() {
    private lateinit var binding: ActivityDetailCarBinding
    private val viewModel: CarById by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("ID_KEY",0)
        getCarById(id)

    }

    private fun getCarById(id : Int) {
        viewModel.getCarById(id).observe(this, Observer { setView(it) })
    }

    private fun setView(data: GetAllCarResponseItem?) {
        Glide.with(this)
            .load(data?.image)
            .fitCenter()
            .into(binding.ivCarDetail)

        binding.tvNameCar.text = data?.name
        binding.tvPriceCar.text = data?.price.toString()
        binding.tvCategoryCar.text = data?.category
        binding.tvNama.text = data?.name
        binding.pbDetail.visibility = View.GONE

    }
}