package com.example.firsthomework.kotlin.ui.pet_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.models.Pets
import kotlinx.android.synthetic.main.activity_dog_detail.*

class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_detail)
        val item = intent.getSerializableExtra("pet") as Pets
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

fun getLikeImage(state: Boolean) = if (state)  R.drawable.ic_liked
else R.drawable.ic_unliked