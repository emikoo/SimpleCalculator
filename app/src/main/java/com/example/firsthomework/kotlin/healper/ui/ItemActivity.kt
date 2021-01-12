package com.example.firsthomework.kotlin.healper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.models.nameArray
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        setupViews()
    }

    private fun setupViews() {
        val value = intent.getSerializableExtra("yourItem")
        item_name.text = "You are welcome $value !"
    }
}
