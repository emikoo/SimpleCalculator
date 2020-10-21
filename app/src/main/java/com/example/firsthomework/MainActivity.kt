package com.example.firsthomework

import android.annotation.SuppressLint
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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        saveInfoInET()
    }

    private fun saveInfoInET(){
        btnSave.setOnClickListener {
            val phoneNumber = edPhoneNumber.text.toString()
            val cityName = edCityName.text.toString()
            val regionName = edRegionName.text.toString()

            if(phoneNumber.isEmpty()){
                showToast("Поле номер телефона не может быть пустым")
                clearET()
            } else if(cityName.isEmpty()){
                showToast("Поле города не может быть пустым")
                clearET()
            } else if(regionName.isEmpty()){
                showToast("Поле область не может быть пустым")
                clearET()
            } else {
                val allInformation = "$phoneNumber $cityName $regionName \n"
                Log.v("ACTIVITY_INFORMATION", allInformation)
            }
        }
    }

    private fun clearET(){
        edPhoneNumber.text.clear()
        edCityName.text.clear()
        edRegionName.text.clear()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}