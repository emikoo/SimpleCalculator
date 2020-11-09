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
