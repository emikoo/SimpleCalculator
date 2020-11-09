package com.example.firsthomework

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    //0. !!!ПОДГОТОВИТЬ ВОПРОСЫ ПО ТЕМАМ, КОТОРЫЕ НЕ ПОНЯТНЫ!!!
//2. (RegistrationActivity) Вынести проверку значений в EditText в отдельный метод
/*4. (RegistrationActivity,
      LoginActivity,
      PasswordActivity) Вынести их проверки полей в отдельный файл */
//5.  Вынести переход на новую актвити в отдельный файл

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
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginAction() {
        login_btn.setOnClickListener {
            val login = login_edit_text.text.toString()
            if (login.isNotEmpty()) {
                if (login != shared.myLogin) {
                    showToast(this, getString(R.string.login_isnt_found))
                    login_edit_text.setText("")
                    return@setOnClickListener
                    finish()
                }
                val intent = Intent(this, PasswordActivity::class.java)
                startActivity(intent)
            } else {
                showToast(this, getString(R.string.fill_in_login))
            }
        }
    }
}