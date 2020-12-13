package com.example.firsthomework.ui.healper

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.R

fun showSingleAlertDialog(action: () -> Unit, activity: AppCompatActivity, header: String, positive: String, negative: String){
    val alert = AlertDialog.Builder(activity, R.style.NewsDialogStyle)

    val inflater = activity.layoutInflater.inflate(R.layout.alert_delete, null)
    alert.setView(inflater)
    val headerTextView = inflater.findViewById<TextView>(R.id.title_dialog)
    val positiveButton = inflater.findViewById<Button>(R.id.positive_button)
    val negativeButton = inflater.findViewById<Button>(R.id.negative_button)
    val dialog = alert.create()
    headerTextView.text = header
    positiveButton.text = positive
    negativeButton.text = negative
    positiveButton.setOnClickListener {
        action()
        dialog.dismiss()
    }
    negativeButton.setOnClickListener {
        dialog.dismiss()
    }
    dialog.show()
}