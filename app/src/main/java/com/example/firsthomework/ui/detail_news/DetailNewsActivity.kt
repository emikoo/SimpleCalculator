package com.example.firsthomework.ui.detail_news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.ui.News
import kotlinx.android.synthetic.main.activity_detail_news.*
import kotlinx.android.synthetic.main.item_news.*

class DetailNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        getDataFromMain()
    }

    private fun getDataFromMain(){
        val item = intent?.getSerializableExtra("news") as News
        setDataToViews(item)
    }

    private fun setDataToViews(data: News){
        Glide
            .with(full_image.context)
            .load(data.image)
            .into(full_image)
        full_title.text = data.title
        full_description.text = data.fullNews
    }
}