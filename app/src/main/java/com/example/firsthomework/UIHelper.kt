package com.example.firsthomework

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.core.content.res.ResourcesCompat.getColorStateList
import com.example.firsthomework.ui.News
import com.example.firsthomework.ui.detail_news.DetailNewsActivity
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
    }.setActionTextColor(getColor(context, R.color.colorYellow)).show()
}

fun showSnackbar(view: View, message: String){
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}


