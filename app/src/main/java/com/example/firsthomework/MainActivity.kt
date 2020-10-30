package com.example.firsthomework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var enteredNumber = 0
    private var operand = ""
    private var default = ""
    private var lastNumber = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showSymbol()
        btnDelete()
        btnReset()
        btnEquals()
    }

    private fun showSymbol(){
        btnDecimal("0", btn0)
        btnDecimal("1", btn1)
        btnDecimal("2", btn2)
        btnDecimal("3", btn3)
        btnDecimal("4", btn4)
        btnDecimal("5", btn5)
        btnDecimal("6", btn6)
        btnDecimal("7", btn7)
        btnDecimal("8", btn8)
        btnDecimal("9", btn9)

        getOperandAction("+", btnPlus)
        getOperandAction("–", btnMinus)
        getOperandAction("×", btnPow)
        getOperandAction("÷", btnSplit)
    }

    private fun btnDecimal(number: String, btn: Button) {
        btn.setOnClickListener {
            default = tvProcess.text.toString()
            default += "$number"
            lastNumber += "$number"
            tvProcess.text = default
        }
    }

    private fun getOperandAction(operando: String, btn: Button) {
        btn.setOnClickListener {
            operand = operando
            default = tvProcess.text.toString()
            if (isDecimal(default.last())) {
                if (enteredNumber == 0) enteredNumber += lastNumber.toInt()
                else enteredNumber *= lastNumber.toInt()
                lastNumber = ""
                default += "$operando"
                tvProcess.text = default
            } else {
                default = default.dropLast(1)
                default += "$operando"
                tvProcess.text = default
            }
        }
    }

    private fun btnDelete(){
        btnDelete.setOnClickListener{
            default = tvProcess.text.toString()
            default = default.dropLast(1)
            tvProcess.text = default
        }
    }

    private fun btnReset() {
        btnReset.setOnClickListener {
            enteredNumber = 0
            lastNumber = ""
            tvProcess.text = ""
            tvResult.text = ""
        }
    }

    private fun btnEquals() {
        btnEquals.setOnClickListener {
            when (operand) {
                "×" -> {
                    val sum = enteredNumber * lastNumber.toInt()
                    tvProcess.text = ""
                    tvResult.text = sum.toString()
                }
                "÷" -> {
                    val sum = enteredNumber / lastNumber.toFloat()
                    tvProcess.text = ""
                    tvResult.text = sum.toString()
                }
                "+" -> {
                    val sum = enteredNumber + lastNumber.toInt()
                    tvProcess.text = ""
                    tvResult.text = sum.toString()
                }
                "–" -> {
                    val sum = enteredNumber - lastNumber.toInt()
                    tvProcess.text = ""
                    tvResult.text = sum.toString()
                }
            }
        }
    }

    private fun isDecimal(last: Char): Boolean {
        val charArray = mutableListOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

        for (char in charArray) {
            if (last == char) return true
        }
        return false
    }
}