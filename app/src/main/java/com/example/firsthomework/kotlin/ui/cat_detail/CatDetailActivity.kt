package com.example.firsthomework.kotlin.ui.cat_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.models.Pets
import com.example.firsthomework.kotlin.ui.cat.adapter.getLikeImage
import kotlinx.android.synthetic.main.activity_cat_detail.*

class CatDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_detail)
        val item = intent.getSerializableExtra("cat") as Pets
        setupViews(item)
    }

    private fun setupViews(item: Pets){
        Glide.with(this)
            .load(item.image)
            .into(image)
        header.text = item.name
        subtitle.text = item.description

        like.setImageResource(getLikeImage(item.isLiked))
    }
}