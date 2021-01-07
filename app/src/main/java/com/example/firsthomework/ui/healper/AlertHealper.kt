package com.example.firsthomework.ui.healper

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.R
import com.example.firsthomework.ui.contacts.MainActivity
import kotlinx.android.synthetic.main.alert_add.*
import kotlinx.android.synthetic.main.alert_delete.*

fun showSingleActionDialog(action: () -> Unit, activity: AppCompatActivity, header: String, positive: String, negative: String) {
    val alert = AlertDialog.Builder(activity, R.style.NewsDialogStyle)

    val inflater = activity.layoutInflater.inflate(R.layout.alert_delete, null)
    alert.setView(inflater)
    val headerTextView: TextView = inflater.findViewById(R.id.header)
    val negativeButton: Button = inflater.findViewById(R.id.negative_button)
    val positiveButton: Button = inflater.findViewById(R.id.positive_button)
    val dialog = alert.create()
    headerTextView.text = header
    negativeButton.text = positive
    positiveButton.text = negative
    negativeButton.setOnClickListener {
        dialog.dismiss()
    }
    positiveButton.setOnClickListener {
        action()
        dialog.dismiss()
    }
    dialog.show()
}