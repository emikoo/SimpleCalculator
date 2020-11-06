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
        setSharedDataAction()
    }

    private fun setSharedDataAction(){
        login_btn.setOnClickListener {
            var login = login_edit_text.text.toString()
            if (!login.isNullOrEmpty()){
                shared.myLogin = "${shared.myLogin} $login \n"

                val intent = Intent(this, PasswordActivity::class.java)
                intent.putExtra("login", shared.myLogin)
                startActivity(intent)

                finish()
            } else {
                Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
            }
        }

    }
}