package com.example.horoscopo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo.R
import com.example.horoscopo.adacters.HoroscopeAdapter
import com.example.horoscopo.data.Horoscope
import com.example.horoscopo.data.HoroscopeProvider

class ListActivity : AppCompatActivity() {
    lateinit var horoscopeList: List<Horoscope>

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recyclerView)

        horoscopeList = HoroscopeProvider.findAll()

        val adapter = HoroscopeAdapter(horoscopeList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }
}