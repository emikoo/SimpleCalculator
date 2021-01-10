package com.example.firsthomework.kotlin.ui.dog_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.models.Pets
import com.example.firsthomework.kotlin.ui.cat.adapter.getLikeImage
import kotlinx.android.synthetic.main.activity_cat_detail.*
import kotlinx.android.synthetic.main.activity_cat_detail.header
import kotlinx.android.synthetic.main.activity_cat_detail.image
import kotlinx.android.synthetic.main.activity_cat_detail.like
import kotlinx.android.synthetic.main.activity_cat_detail.subtitle
import kotlinx.android.synthetic.main.activity_dog_detail.*

class DogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_detail)
        val item = intent.getSerializableExtra("dog") as Pets
        setupViews(item)
    }

    private fun setupViews(item: Pets){
        Glide.with(this)
            .load(item.image)
            .into(image_dog)
        header_dog.text = item.name
        subtitle_dog.text = item.description

        like_dog.setImageResource(getLikeImage(item.isLiked))
    }
}