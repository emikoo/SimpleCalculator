package com.example.firsthomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_password.*

class PasswordActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        shared = SharedPreferences(this)

        confirmAction()
    }

    private fun confirmAction() {
        confirm_password_btn.setOnClickListener {
            val password = password_edit_text.text.toString()
            if (password.isNotEmpty()){
                if(password != shared.password){
                    showToast(this, getString(R.string.password_isnt_found))
                    return@setOnClickListener
                    finish()
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                showToast(this, getString(R.string.password))
            }
        }
    }
}