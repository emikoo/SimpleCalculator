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

class ShowAddEditingDialog(context: Context, private var headerTitle: String, private var listener: OnAddEditListener, var type: Int): Dialog(context, R.style.NewsDialogStyle) {

    //type 0 - add, 1 - edit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alert_add)
        header.text = headerTitle
        add_negative_button.setOnClickListener { dismiss() }
        add_positive_button.setOnClickListener { listener.addEditingDialog(type, Contact(
            set_image.text.toString(),
            first_name_edit_text.text.toString(),
            last_name_edit_text.text.toString(),
            email_edit_text.text.toString())
        )
        dismiss() }
    }

}

interface OnAddEditListener {
    fun addEditingDialog(type: Int, contact: Contact)
}