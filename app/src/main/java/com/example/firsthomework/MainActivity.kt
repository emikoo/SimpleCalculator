package com.example.firsthomework

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var enteredNumber: Float = 0.0f
    private var operand = ""
    private var default = ""
    private var lastNumber = ""
    private val decimalArrayButtons = mutableListOf<Button>()
    private val operandArrayButtons = mutableListOf<Button>()
    private var equalsArrayList = mutableListOf<String>()

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

        btnNextActivityAction()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState.putFloat("enteredNumber", enteredNumber)
        outState.putString("operand", operand)
        outState.putString("default", default)
        outState.putString("lastNumber", lastNumber)
        outState.putStringArrayList("equalsArrayList", equalsArrayList as ArrayList<String>)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        enteredNumber = savedInstanceState.getFloat("enteredNumber")
        operand = savedInstanceState.getString("operand").toString()
        default = savedInstanceState.getString("default").toString()
        lastNumber = savedInstanceState.getString("lastNumber").toString()
        equalsArrayList = savedInstanceState.getStringArrayList(("equalsArrayList").toString())!!
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

    private fun setOperandButtonsToArray() {
        operandArrayButtons.apply {
            add(btnPlus)
            add(btnMinus)
            add(btnPow)
            add(btnSplit)
        }
    }

    private fun setOperandButtons() {
        for (btn in operandArrayButtons) {
            btn.setOnClickListener {
                getOperandAction(btn.text as String)
            }
        }
    }

    private fun getOperandAction(type: String) {
        var text = tvProcess.text.toString()
        if (text.isNullOrEmpty()) {
            return
        }
        default = tvProcess.text.toString()
        if (isDecimal(default.last())) {
            if (enteredNumber == 0.0f) enteredNumber += lastNumber.toFloat()
            lastNumber = ""
        } else {
            default = default.dropLast(1)
        }
        default += type
        if (tvProcess.text.isEmpty()) {
            tvResult.text = default
            tvProcess.text = ""
        } else tvProcess.text = default
        operand = type
    }

    private fun btnDelete() {
        btnDelete.setOnClickListener {
            if (default.isNotEmpty()) {
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
                "×" -> {
                    enteredNumber *= lastNumber.toFloat()
                }
                "÷" -> {
                    enteredNumber /= lastNumber.toFloat()
                }
                "+" -> {
                    enteredNumber += lastNumber.toFloat()
                }
                "–" -> {
                    enteredNumber -= lastNumber.toFloat()
                }
            }
            displayResult()
        }
    }

    private fun displayResult() {
        if (enteredNumber % 1 == 0.0f) {
            tvResult.text = enteredNumber.roundToInt().toString()
            tvProcess.text = enteredNumber.roundToInt().toString()
        } else {
            tvProcess.text = String.format("%.2f", enteredNumber)
            tvResult.text = String.format("%.2f", enteredNumber)
        }
        var result = tvResult.text.toString()
        equalsArrayList.add(result)
        lastNumber = ""
    }

    private fun isDecimal(last: Char): Boolean {
        val charArray = mutableListOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

        for (char in charArray) {
            if (last == char) return true
        }
        return false
    }

    private fun btnNextActivityAction() {
        btnNextActivity.setOnClickListener {
            val intent = Intent(this, ListOfEqualsActivity::class.java)
            intent.putStringArrayListExtra("list", equalsArrayList as ArrayList<String>)
            startActivity(intent)
        }
    }
}