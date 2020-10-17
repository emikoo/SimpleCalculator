package com.example.firsthomework

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isMinus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTotal()
        setPlusOperator()
        setMinusOperator()
    }

    @SuppressLint("SetTextI18n")
    private fun getTotal() {
        btnGo.setOnClickListener {
            val firstNum: Int = edFirstNum.text.toString().toInt()
            val secondNum: Int = edSecondNum.text.toString().toInt()
            var result: Int? = null
            if(isMinus) result = firstNum - secondNum
            else result = firstNum + secondNum

            tvTotal.text = "= $result"
            tvPlusOrMinus.text = "__"
            edFirstNum.text.clear()
            edSecondNum.text.clear()
        }
    }

    private fun setPlusOperator(){
        btnPlus.setOnClickListener {
            isMinus = false

            tvTotal.text = ""
            tvPlusOrMinus.text = "+"
        }
    }

    private fun setMinusOperator(){
        btnMinus.setOnClickListener {
            isMinus = true

            tvTotal.text = ""
            tvPlusOrMinus.text = "-"
        }
    }
}