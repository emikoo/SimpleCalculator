package com.example.firsthomework.ui.news

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.newsArray
import com.example.firsthomework.showSnackBar
import com.example.firsthomework.startIntent
import com.example.firsthomework.ui.News
import com.example.firsthomework.ui.detail_news.DetailNewsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsAdapter.Listener {

    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupAdapter()
    }

    private fun setupAdapter(){
        adapter = NewsAdapter(this)
        news_list.layoutManager = LinearLayoutManager(this)
        news_list.adapter = adapter
        adapter.updateItem(newsArray)
    }

    override fun onItemClick(item: News) {
        showSnackBar(news_list, item.title, this, DetailNewsActivity::class.java, item)
    }
}
