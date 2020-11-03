package com.example.firsthomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_of_eguals.*

class ListOfEqualsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_eguals)

        getListOfEquals()
    }

    private fun getListOfEquals() {
        val value = intent.getStringArrayListExtra("list")
        var results: String = ""

        if(value != null)
            for (i in value){
                results += "$i \n"
            }
        tvListOfEquals.text = results
    }
}