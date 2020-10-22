package com.example.firsthomework

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.constraint_layout.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        changeIconAction()
    }

    private fun changeIconAction() {
        refresh_image_button.setOnClickListener {
            val citiesArray = arrayOf(R.mipmap.ic_tokyo, R.mipmap.ic_fukuoka, R.mipmap.ic_kyoto,
                R.mipmap.ic_nagoya, R.mipmap.ic_osaka, R.mipmap.ic_sapporo, R.mipmap.ic_yokohama)
            .random()
            image.setImageResource(citiesArray)
        }
    }
}