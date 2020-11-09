package com.example.firsthomework

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    
    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        shared = SharedPreferences(this)

        registrationAction()
        loginAction()
    }

    private fun registrationAction() {
        registration_button.setOnClickListener {
            startActivityAction(this, RegistrationActivity::class.java)
        }
    }

    private fun loginAction() {
        login_btn.setOnClickListener click@{
            val login = login_edit_text.text.toString()
            if(checkFieldIsEmpty(login, this, getString(R.string.fill_in_login))) return@click
            if (checkFieldNotSame(login, shared.myLogin, this, getString(R.string.login_isnt_found))) return@click
            startActivityAction(this, PasswordActivity::class.java)
            finish()
        }
    }
}