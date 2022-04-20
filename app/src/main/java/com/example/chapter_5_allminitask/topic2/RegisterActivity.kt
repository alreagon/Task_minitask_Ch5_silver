package com.example.chapter_5_allminitask.topic2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.chapter_5_allminitask.R
import com.example.chapter_5_allminitask.databinding.ActivityRegisterBinding
import com.example.chapter_5_allminitask.topic2.model.PostRegisterResponse
import com.example.chapter_5_allminitask.topic2.model.RegisterRequest
import com.example.chapter_5_allminitask.topic2.model.RegisterRequestAdd
import com.example.chapter_5_allminitask.topic2.network.ApiClient
import com.example.chapter_5_allminitask.topic2.viewmodel.CarById
import com.example.chapter_5_allminitask.topic2.viewmodel.RegisterUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterUser by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()

    }

    private fun setupViews() {
        binding.apply {
            btnDaftarRegis.setOnClickListener {
                if (!etEmailregis.text.isNullOrEmpty() && !etPassRegis.text.isNullOrEmpty()) {
                    binding.pbLoading.visibility = View.VISIBLE
//                    registerAction(etEmailregis.text.toString(), etPassRegis.text.toString())
                    postAdminRegister(etEmailregis.text.toString(), etPassRegis.text.toString())
                    binding.pbLoading.visibility = View.GONE
                } else {
                    Toast.makeText(
                        this@RegisterActivity,
                        "Data tidak boleh kosong!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun postAdminRegister(email: String, pass: String) {
        viewModel.getRegisterUser(email, pass).observe(this, Observer { setView(it) })
    }

    private fun setView(data: RegisterRequestAdd?) {
        Log.d("code", "${data!!.code}")
        if (data.code == 201) {
            Toast.makeText(this@RegisterActivity, "Register berhasil!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this@RegisterActivity, "Register gagal!", Toast.LENGTH_SHORT).show()
        }
    }

//    private fun registerAction(email: String, password: String) {
//
//        val request = RegisterRequest(
//            email = email,
//            password = password,
//            role = "admin"
//        )
//        ApiClient.instance.postRegister(request)
//            .enqueue(object : Callback<PostRegisterResponse> {
//                override fun onResponse(
//                    call: Call<PostRegisterResponse>,
//                    response: Response<PostRegisterResponse>
//                ) {
//                    val code = response.code()
//                    if (code == 201) {
//                        binding.pbLoading.visibility = View.GONE
//                        Toast.makeText(
//                            this@RegisterActivity, "Register Berhasil!", Toast.LENGTH_SHORT
//                        ).show()
//                        finish()
//                    } else {
//                        binding.pbLoading.visibility = View.GONE
//                        Toast.makeText(
//                            this@RegisterActivity, "Email sudah tersedia", Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//
//                override fun onFailure(call: Call<PostRegisterResponse>, t: Throwable) {
//                    Toast.makeText(this@RegisterActivity, "${t.message}", Toast.LENGTH_SHORT).show()
//                    binding.pbLoading.visibility = View.GONE
//                }
//
//            })
//    }
}