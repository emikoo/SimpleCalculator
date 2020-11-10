package com.example.firsthomework

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

const val LOGIN = "login"
const val PASSWORD = "password"
const val CONFIRM_PASSWORD = "confirm_password"
const val IS_AUTHORIZATION = "is_authorization"

class SharedPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("kotlin-app", Context.MODE_PRIVATE)

    var myLogin: String
        get() {
            return sharedPreferences.getStringOrDefault(LOGIN)
        }
        set(value) {
            sharedPreferences.edit {
                putString(LOGIN, value)
            }
        }

    var password: String
        get() {
            return sharedPreferences.getStringOrDefault(PASSWORD)
        }
        set(value) {
            sharedPreferences.edit() {
                putString(PASSWORD, value)
            }
        }

    var confirmPassword: String
        get() {
            return sharedPreferences.getStringOrDefault(CONFIRM_PASSWORD)
        }
        set(value) {
            sharedPreferences.edit() {
                putString(CONFIRM_PASSWORD, value)
            }
        }

    var isAuthorization: Boolean
    get() {
        return sharedPreferences.getBoolean(IS_AUTHORIZATION, false)
    }
    set(value) {
       sharedPreferences.edit() {
           putBoolean(IS_AUTHORIZATION, value)
       }
    }

    private fun SharedPreferences.getStringOrDefault(key: String, default: String = "") =
        getString(key, default) ?: default
}