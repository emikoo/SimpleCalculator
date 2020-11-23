package com.example.firsthomework.ui.news

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.newsArray
import com.example.firsthomework.showSnackBar
import com.example.firsthomework.ui.News
import com.example.firsthomework.ui.detail_news.DetailNewsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.*


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
        val intent = Intent(this, DetailNewsActivity::class.java)
        intent.putExtra("news", item)
        startActivity(intent)
    }

    private var news: News? = null
    var position: Int? = null

    override fun onLongItemClick(item: News, position: Int) {
        news = item
        this.position = position
        deleteAlertDialog()
    }

    private fun deleteItem(){
        adapter.deleteItem(position!!)
        showSnackBar(news_list, "Новость удалена", "Востановить", this::restoreNewsItem, this)
    }

    private fun restoreNewsItem(){
        if (news != null && position != null) adapter.restoreItem(news!!, position!!)
    }

    private fun deleteAlertDialog(){
        val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)
        val inflater = layoutInflater.inflate(R.layout.custom_dialog, null)
        alert.setView(inflater)
        var title: TextView = inflater.findViewById(R.id.title_dialog)
        var positive: Button = inflater.findViewById(R.id.positive_button)
        var negative: Button = inflater.findViewById(R.id.negative_button)
        var dialog = alert.create()
        title.setText(R.string.title_dialog)
        positive.text = "Удалить"
        negative.text = "Отменить"
        positive.setOnClickListener {
            deleteItem()
            dialog.dismiss()
        }
        negative.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}
