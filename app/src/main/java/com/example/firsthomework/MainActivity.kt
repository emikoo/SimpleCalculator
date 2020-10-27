package com.example.firsthomework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var text: String? = null
    var array = mutableListOf<String>()
    var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getValueAction()
        showArrayAction()
    }

    private fun getValueAction() {
        btnShow.setOnClickListener {
            text = edText.text.toString()

            if (text!!.isEmpty() || text!!.isBlank()) {
                showToast("Поле не дожно быть пустым")
                edText.text.clear()
            } else {
                array.add("$text")

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("text", text)
                edText.text.clear()

                startActivity(intent)
            }
        }
    }

    private fun showArrayAction() {
        btnShowAllValues.setOnClickListener {
            var list = ""
            array.forEach {
                list = if(list.isEmpty()){
                    "$it"
                } else {
                    "$list $it \n"
                }
                showToast(list)
            }
        }
    }

    @SuppressLint("ShowToast")
    private fun showToast(message: String) {
        if (toast != null) toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast?.show()
    }
}