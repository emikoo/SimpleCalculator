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

    var username = "Адеми"
    var lastname = "Абдыкеримова"
    var age = "16"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        setupView()
        saveInfoInET()
    }

    private fun setupView(){
        tvUsername.text = username
        tvLastName.text = lastname
        tvAge.text = age
    }

    private fun saveInfoInET(){
        btnSave.setOnClickListener {
            val phoneNumber = edPhoneNumber.text.toString()
            val cityName = edCityName.text.toString()
            val regionName = edRegionName.text.toString()

            if (phoneNumber.isEmpty() && cityName.isEmpty() && regionName.isEmpty()){
                showToast("Заполните все поля")
                return@setOnClickListener
            }
            checkFields(phoneNumber, "Поле номер телефона не может быть пустым")
            checkFields(cityName, "Поле города не может быть пустым")
            checkFields(regionName, "Поле область не может быть пустым")
            val allInformation = "$phoneNumber, $cityName, $regionName"
            Log.v("ACTIVITY_INFORMATION", allInformation)
        }
    }
    
    private fun checkFields(value: String, message: String) {
        if (value.isEmpty() || value.isBlank()) {
            showToast(message)
            return
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}