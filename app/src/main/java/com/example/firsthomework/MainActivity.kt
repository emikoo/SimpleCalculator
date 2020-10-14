package com.example.firsthomework

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var tvTotal: TextView? = null
    var edFirstNum: EditText? = null
    var edSecondNum: EditText? = null
    var btnGo: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        getTotal()
    }

    private fun setupViews() {
        tvTotal = findViewById(R.id.tvTotal)
        edFirstNum = findViewById(R.id.edFirstNum)
        edSecondNum = findViewById(R.id.edSecondNum)
        btnGo = findViewById(R.id.btnGo)
    }

    @SuppressLint("SetTextI18n")
    private fun getTotal() {
        btnGo?.setOnClickListener {
            val firstNum: Int = edFirstNum?.text.toString().toInt()
            val secondNum: Int = edSecondNum?.text.toString().toInt()

            val result: Int = firstNum+secondNum

            tvTotal?.text = "= $result"
            edFirstNum?.setText("")
            edSecondNum?.setText("")
        }
    }
}