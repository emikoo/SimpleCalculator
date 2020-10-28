package com.example.firsthomework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showSymbol()
        getResetAction()
    }

    private fun showSymbol(){
        btnSymbol("1", btn1)
        btnSymbol("2", btn2)
        btnSymbol("3", btn3)
        btnSymbol("4", btn4)
        btnSymbol("5", btn5)
        btnSymbol("6", btn6)
        btnSymbol("7", btn7)
        btnSymbol("8", btn8)
        btnSymbol("9", btn9)

        btnSymbol("÷", btnShare)
        btnSymbol("×", btnPow)
        btnSymbol("–", btnMinus)
        btnSymbol("+", btnPlus)
    }

    private fun getDeleteLastSymbolAction({
        btnDelete.setOnClickListener {

        }
    })

    private fun getResetAction(){
        btnReset.setOnClickListener {
            tvProcess.text = ""
        }
    }

    private fun btnSymbol(symbol: String, btn: Button) {
        btn.setOnClickListener {
            var default = tvProcess.text.toString()
            default += "$symbol"
            tvProcess.text = default
        }
    }

}