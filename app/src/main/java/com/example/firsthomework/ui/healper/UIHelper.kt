package com.example.firsthomework.ui.healper

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor
import com.example.firsthomework.R
import com.google.android.material.snackbar.Snackbar

fun showToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun showActionSnackbar(
    view: View,
    message: String,
    actionTitle: String,
    action: () -> Unit,
    context: Context
) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction(actionTitle){
        action()
    }.setActionTextColor(getColor(context,
        R.color.colorYellow
    )).show()
}

fun showSnackbar(view: View, message: String){
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

fun checkFieldIsEmpty(value: String, context: Context, message: String): Boolean {
    if (value.isEmpty()){
        showToast(context, message)
        return true
    }
    return false
}


