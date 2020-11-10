package com.example.firsthomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var shared: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shared = SharedPreferences(this)
        shared.isAuthorization = false

        logoutAction()
    }

    private fun logoutAction(){
        logout_btn.setOnClickListener {
            clearSPAction()
            shared.isAuthorization = true
            startActivityAction(this, LoginActivity::class.java)
        }
    }

    private fun clearSPAction() {
        shared.myLogin = ""f
        shared.password = ""
        shared.confirmPassword = ""
        finish()
    }
}
