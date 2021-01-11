package com.example.firsthomework.kotlin.healper

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

const val NAME = "name"
const val SURNAME = "surname"
const val PHONE_NUMBER = "phone_number"
const val IS_PERMITTED = "permission"

class SharedPreference(context: Context){
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("authorization_application", Context.MODE_PRIVATE)

    var name: String
        get() {
            return sharedPreferences.getStringOrDefault(NAME, "Ademi")
        }
        set(value) {
            sharedPreferences.edit {
                putString(NAME, value)
            }
        }

    var surname: String
        get() {
            return sharedPreferences.getStringOrDefault(SURNAME, "Abdykerimova")
        }
        set(value) {
            sharedPreferences.edit {
                putString(SURNAME, value)
            }
        }

    var phoneNumber: String
        get() {
            return sharedPreferences.getStringOrDefault(PHONE_NUMBER, "+996701988815")
        }
        set(value) {
            sharedPreferences.edit {
                putString(PHONE_NUMBER, value)
            }
        }

    var isPermitted: Boolean
        get() {
            return sharedPreferences.getBoolean(IS_PERMITTED, false)
        }
        set(value) {
            sharedPreferences.edit {
                putBoolean(IS_PERMITTED, value)
            }
        }

    private fun SharedPreferences.getStringOrDefault(key: String, default: String = "") =
        getString(key, default) ?: default
}