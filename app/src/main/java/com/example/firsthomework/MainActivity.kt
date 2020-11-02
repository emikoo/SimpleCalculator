package com.example.firsthomework

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var enteredNumber: Float = 0.0f
    private var operand = ""
    private var default = ""
    private var lastNumber = ""
    private val decimalArrayButtons = mutableListOf<Button>()
    private val operandArrayButtons = mutableListOf<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDelete()
        btnReset()
        btnEquals()

        setDecimalButtonsToArray()
        setDecimalButtons()

        setOperandButtonsToArray()
        setOperandButtons()
    }

    private fun setDecimalButtonsToArray() {
        decimalArrayButtons.apply {
            add(btn0)
            add(btn1)
            add(btn2)
            add(btn3)
            add(btn4)
            add(btn5)
            add(btn6)
            add(btn7)
            add(btn8)
            add(btn9)
            add(btnPoint)
        }
    }

    private fun setOperandButtonsToArray() {
        operandArrayButtons.apply {
            add(btnPlus)
            add(btnMinus)
            add(btnPow)
            add(btnSplit)
        }
    }

    private fun setDecimalButtons() {
        for (btn in decimalArrayButtons) {
            btn.setOnClickListener {
                default = tvProcess.text.toString()
                default += btn.text
                lastNumber += btn.text
                tvProcess.text = default
            }
        }
    }

    private fun setOperandButtons(){
        for(btn in operandArrayButtons){
            btn.setOnClickListener {
                getOperandAction(btn.text as String)
            }
        }
    }

    private fun getOperandAction(type: String) {
        default = tvProcess.text.toString()
        if (isDecimal(default.last())) {
            if (enteredNumber == 0.0f) enteredNumber += lastNumber.toFloat()
            lastNumber = ""
        } else {
            default = default.dropLast(1)
        }
            default += type
        if (tvProcess.text.isEmpty()){
            tvResult.text = default
            tvProcess.text = ""
        }
        else tvProcess.text = default
        operand = type
    }

    private fun btnDelete(){
        btnDelete.setOnClickListener{
            if (default.isNotEmpty()){
                default = default.dropLast(1)
                tvProcess.text = default
            }
        }
    }

    private fun btnReset() {
        btnReset.setOnClickListener {
            enteredNumber = 0.0f
            lastNumber = ""
            tvProcess.text = ""
            tvResult.text = ""
        }
    }

    private fun btnEquals() {
        btnEquals.setOnClickListener {
            when (operand) {
                "×" -> enteredNumber *= lastNumber.toFloat()
                "÷" -> enteredNumber /= lastNumber.toFloat()
                "+" -> enteredNumber += lastNumber.toFloat()
                "–" -> enteredNumber -= lastNumber.toFloat()
            }
            tvResult.text = enteredNumber.toString()
            tvProcess.text = enteredNumber.toString()
            lastNumber = ""
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