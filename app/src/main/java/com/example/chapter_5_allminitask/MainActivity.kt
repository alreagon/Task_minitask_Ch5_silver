package com.example.chapter_5_allminitask

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.example.chapter_5_allminitask.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.biruMantep)


        binding.topic1.setOnClickListener {
            val Intent = Intent(this, Json::class.java)
            startActivity(Intent)
        }
        binding.topic1.setOnLongClickListener {
            Toast.makeText(this, "JSON dan REST API", Toast.LENGTH_SHORT).show()
            true
        }



    }
}