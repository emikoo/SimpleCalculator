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
        registration_button.setOnClickListener {
            val login = login_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            val confirmPassword = confirm_password_edit_text.text.toString()

            if (login.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                showToast(this, getString(R.string.fill_in_all_fields))
                return@setOnClickListener
            }

            if (login.length <= 5){
                showToast(this, getString(R.string.login_6_symbols))
                return@setOnClickListener
            }

            if (login == shared.myLogin){
                showToast(this, getString(R.string.this_login_is_existed))
                return@setOnClickListener
            }

            if (password.length <= 5){
                showToast(this, getString(R.string.password_6_symbols))
                return@setOnClickListener
            }

            if (password != confirmPassword){
                showToast(this, getString(R.string.passwords_arent_same))
                return@setOnClickListener
            }

            shared.myLogin = login
            shared.password = password
            shared.confirmPassword = confirmPassword
            showToast(this, getString(R.string.you_registered))

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}