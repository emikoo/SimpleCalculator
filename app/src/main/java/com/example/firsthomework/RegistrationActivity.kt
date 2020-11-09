package com.example.firsthomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_password.*
import kotlinx.android.synthetic.main.activity_password.password_edit_text
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        shared = SharedPreferences(this)

        registrationAction()
    }

    private fun registrationAction() {
        registration_button.setOnClickListener click@ {
            val login = login_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            val confirmPassword = confirm_password_edit_text.text.toString()

            if (checkFieldIsEmpty(login, this, getString(R.string.fill_in_all_fields))) return@click
            if (checkFieldIsEmpty(password, this, getString(R.string.fill_in_all_fields))) return@click
            if (checkFieldIsEmpty(confirmPassword, this, getString(R.string.fill_in_all_fields))) return@click

            if (checkFieldLength(login, this, getString(R.string.login_6_symbols))) return@click
            if (checkFieldLength(password, this, getString(R.string.password_6_symbols))) return@click

            if (checkFieldIsSame(login, shared.myLogin, this, getString(R.string.this_login_is_existed)))
            if (checkFieldNotSame(password, confirmPassword, this, getString(R.string.passwords_arent_same))) return@click

            successRegistered(login, password, confirmPassword)
            startActivityAction(this, MainActivity::class.java)
        }
    }

    private fun successRegistered(login: String, password: String, confirmPassword: String) {
        shared.myLogin = login
        shared.password = password
        shared.confirmPassword = confirmPassword
        showToast(this, getString(R.string.you_registered))
        finish()
    }
}