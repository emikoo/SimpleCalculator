package com.example.firsthomework.kotlin.healper.ui

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.models.Name
import com.example.firsthomework.kotlin.healper.models.nameArray
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainAdapter.OnItemClick {

    //+Сделать нажатие на элемент и переход на следующее активити

    lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = MainAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter.update(nameArray)
    }

    override fun onItemClick(item: Name, position: Int) {
        val intent = Intent(this, ItemActivity::class.java)
        val itemId = adapter.getItemId(position)
        val name = nameArray[position]
        val itemName = name.name
        intent.putExtra("yourItem", itemName)
        startActivity(intent)
    }
}

