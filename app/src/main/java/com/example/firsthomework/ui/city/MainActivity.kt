package com.example.firsthomework.ui.city

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.cityArray
import com.example.firsthomework.ui.City
import com.example.firsthomework.ui.detail_city.CityActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAdapter.Listener {

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = MainAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter
        adapter.updateItems(cityArray)
    }

    override fun onItemClick(item: City) {
        val intent = Intent(this, CityActivity::class.java)
        intent.putExtra("city", item)
        startActivity(intent)
    }
}
