package com.example.firsthomework

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

const val TEXT_LOGIN = "login_from_edit_text"

class SharedPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("kotlin-app", Context.MODE_PRIVATE)

    var myLogin: String
        get(){
            return sharedPreferences.getStringOrDefault(TEXT_LOGIN)
    }
        set(value) {
            sharedPreferences.edit{
                putString(TEXT_LOGIN, value)
            }
        }

    private fun SharedPreferences.getStringOrDefault(key: String, default: String = "") =
        getString(key, default) ?: default
}