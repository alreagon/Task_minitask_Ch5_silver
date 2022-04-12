package com.example.chapter_5_allminitask

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.chapter_5_allminitask.databinding.ActivityJsonBinding
import org.json.JSONArray
import org.json.JSONObject

class Json : AppCompatActivity() {
    private lateinit var binding: ActivityJsonBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJsonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.birutoscabagus)


        val MainjsonObject = JSONObject()
        MainjsonObject.put("status", "OK")
        MainjsonObject.put("message", "Success")


        val jsonArrayListDetails = JSONArray()

        val jsonBook = JSONObject()
            .put("name", "Book")
            .put("price", 100000)
            .put("code", "BK120901920")
            .put("discount", 0)
            .put("qty", 1)
            .put("new", true)
        val jsonCandle = JSONObject()
            .put("name", "Candle")
            .put("price", 75000)
            .put("code", "CD120103929")
            .put("discount", 70000)
            .put("qty", 2)
            .put("new", true)

        jsonArrayListDetails.put(jsonBook)
        jsonArrayListDetails.put(jsonCandle)


        val jsonData = JSONObject()
            .put("amount", 18000)
            .put("qty", 3)
            .put("paid", 200000)
            .put("change", 20000)
            .put("detail", jsonArrayListDetails)
        MainjsonObject.put("data", jsonData)

        val receipt = JSONObject()
            .put("store", "TokoPaedi")
            .put("addreess", "Bandung")
            .put("add_note", "All you can it")

        MainjsonObject.put("receipt", receipt)

        //=========================================

        val store = MainjsonObject.getJSONObject("receipt").getString("store")
        binding.tvStore.text = store
        val address = MainjsonObject.getJSONObject("receipt").getString("addreess")
        binding.tvAdress.text = address
        val add_note = MainjsonObject.getJSONObject("receipt").getString("add_note")
        binding.tvAddNote.text = add_note

        val bookbook = MainjsonObject.getJSONObject("data").getJSONArray("detail").getJSONObject(0)
            .getString("name")
        val bookPrice = MainjsonObject.getJSONObject("data").getJSONArray("detail").getJSONObject(0)
            .getInt("price")
        val qtyBook = MainjsonObject.getJSONObject("data").getJSONArray("detail").getJSONObject(0)
            .getInt("qty")
        val discBook = MainjsonObject.getJSONObject("data").getJSONArray("detail").getJSONObject(0)
            .getInt("discount")
        val hasilBuk = (bookPrice - discBook) * qtyBook
        binding.buk.text = "$bookbook x$qtyBook"
        binding.tvBook.text = "Rp.$hasilBuk"

        val candle = MainjsonObject.getJSONObject("data").getJSONArray("detail").getJSONObject(1)
            .getString("name")
        val candlePrice =
            MainjsonObject.getJSONObject("data").getJSONArray("detail").getJSONObject(1)
                .getInt("price")
        val qtyCandle = MainjsonObject.getJSONObject("data").getJSONArray("detail").getJSONObject(1)
            .getInt("qty")
        val discCandle =
            MainjsonObject.getJSONObject("data").getJSONArray("detail").getJSONObject(1)
                .getInt("discount")
        val hasilCandle = (candlePrice * qtyCandle) - discCandle

        binding.candle.text = "$candle x$qtyCandle"
        binding.tvCancdle.text = "Rp.$hasilCandle"

        val paid = MainjsonObject.getJSONObject("data").getInt("paid")
        val total = hasilBuk + hasilCandle
        val kembalian = paid - total
        binding.tvTotalPrice.text = "Rp.$total"
        binding.tvBayarPrice.text = "Rp.$paid"
        binding.tvKembaliPrice.text = "Rp.$kembalian"

    }
}