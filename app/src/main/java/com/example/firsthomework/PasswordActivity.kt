package com.example.firsthomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_password.*

class PasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        getSharedDataAction()
    }

    private fun getSharedDataAction(){
        val value = intent.getStringExtra("login")
        list_login_tex_view.text = value
    }
}