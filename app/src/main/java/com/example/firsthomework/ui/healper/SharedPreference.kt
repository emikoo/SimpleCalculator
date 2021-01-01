package com.example.firsthomework.ui.healper

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

const val NAME = "name"
const val SURNAME = "surname"

class SharedPreference(context: Context){
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("authorization_application", Context.MODE_PRIVATE)

    var name: String
        get() {
            return sharedPreferences.getStringOrDefault(NAME, "Sergey")
        }
        set(value) {
            sharedPreferences.edit {
                putString(NAME, value)
            }
        }

    var surname: String
        get() {
            return sharedPreferences.getStringOrDefault(SURNAME, "Karukes")
        }
        set(value) {
            sharedPreferences.edit {
                putString(SURNAME, value)
            }
        }

    private fun SharedPreferences.getStringOrDefault(key: String, default: String = "") =
        getString(key, default) ?: default
}