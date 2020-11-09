package com.example.firsthomework

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings.Global.getString
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity

fun showToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun checkFieldIsEmpty(value: String, context: Context, message: String): Boolean{
    if (value.isEmpty()) {
        showToast(context, message)
        return true
    }
    return false
}

fun checkFieldLength(value: String, context: Context, message: String): Boolean{
    if (value.length <= 5){
        showToast(context, message)
        return true
    }
    return false
}

fun checkFieldNotSame(first: String, second: String, context: Context, message: String): Boolean{
    if (first != second){
        showToast(context, message)
        return true
    }
    return false
}

fun checkFieldIsSame(first: String, second: String, context: Context, message: String): Boolean{
    if (first == second){
        showToast(context, message)
        return true
    }
    return false
}

fun startActivityAction(context: Context, clazz: Class<*>){
    val intent = Intent(context, clazz)
    context.startActivity(intent)
}

