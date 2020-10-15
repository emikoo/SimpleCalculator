package com.example.firsthomework

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var tvTotal: TextView? = null
    var tvPlusOrMinus: TextView? = null
    var edFirstNum: EditText? = null
    var edSecondNum: EditText? = null
    var btnPlus: Button? = null
    var btnMinus: Button? = null
    var btnGo: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
        getTotal()
    }

    private fun setupViews() {
        tvTotal = findViewById(R.id.tvTotal)
        tvPlusOrMinus = findViewById(R.id.tvPlusOrMinus)
        edFirstNum = findViewById(R.id.edFirstNum)
        edSecondNum = findViewById(R.id.edSecondNum)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnGo = findViewById(R.id.btnGo)
    }

    @SuppressLint("SetTextI18n")
    private fun getTotal() {
        var result: Int? = null

        btnPlus?.setOnClickListener {
            val firstNum: Int = edFirstNum?.text.toString().toInt()
            val secondNum: Int = edSecondNum?.text.toString().toInt()

            tvTotal?.text = ""
            tvPlusOrMinus?.text = "+"
            result = firstNum + secondNum
        }

        btnMinus?.setOnClickListener {
            val firstNum: Int = edFirstNum?.text.toString().toInt()
            val secondNum: Int = edSecondNum?.text.toString().toInt()

            tvTotal?.text = ""
            tvPlusOrMinus?.text = "-"
            result = firstNum - secondNum
        }

        btnGo?.setOnClickListener {
            tvTotal?.text = "= $result"

            tvPlusOrMinus?.text = "__"
            edFirstNum?.setText("")
            edSecondNum?.setText("")
        }
    }
}