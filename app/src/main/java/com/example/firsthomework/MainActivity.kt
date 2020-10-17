package com.example.firsthomework

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var textArray = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addToArray()
        removeFromArray()
    }

    //textChangedListener

    private fun addToArray(){
        btnAdd.setOnClickListener {
            val value = edText.text.toString()
            if (value.isBlank() || value.isEmpty()) {
                edText.text.clear()
            } else {
                edText.text.clear()
                textArray.add(value)
                displayArray()
            }
        }
    }

    private fun removeFromArray(){
        btnRemove.setOnClickListener {
            var value = edText.text.toString()
            if (value.isBlank() || value.isEmpty()) {
                edText.text.clear()
            } else {
                edText.text.clear()
                findAndRemoveFromArray(value)
                displayArray()
            }
        }
    }

    private fun findAndRemoveFromArray(value: String) {
        var indexOfArray: Int? = null
        var elements = ""
        for((i,text) in textArray.withIndex()){
            if (text == value) {
                indexOfArray = i
                elements = text
            }
        }
        if(indexOfArray != null){
            textArray.removeAt(indexOfArray)
            Toast.makeText(this, "$elements удален", Toast.LENGTH_LONG).show()
        }
    }

    private fun displayArray() {
        var result = ""
        for(list in textArray){
            result = "$result $list \n"
        }
        tvList.text = result
    }
}