package com.example.firsthomework.ui.detail_city

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firsthomework.R
import com.example.firsthomework.ui.City
import kotlinx.android.synthetic.main.activity_city.*

class CityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        getDataFromIntent()
    }

    private fun getDataFromIntent(){
        val item = intent.getSerializableExtra("city") as City
        setItemDataToViews(item)
    }

    private fun setItemDataToViews(data: City) {
        city_image.setImageResource(data.image)
        city_name.text = data.name
        city_created_data.text = data.createdData.toString()
        city_population.text = data.population.toString()
        city_square.text = data.square
        full_description.text = data.fullDescription
    }
}