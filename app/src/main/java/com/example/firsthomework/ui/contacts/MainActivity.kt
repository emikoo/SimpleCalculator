package com.example.firsthomework.ui.contacts

import android.graphics.Canvas
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firsthomework.R
import com.example.firsthomework.ui.healper.Contact
import com.example.firsthomework.ui.healper.contactArray
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //+При нажатии на фаб баттон сделать добавление пользователя, вместе с проверками на поля (image, firstName, lastName, email)
    //+ *Задание на поиск решения* - Сделать закругление для картинки

    lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
        addAction()
    }

    private fun setupAdapter() {
        adapter = ContactAdapter()
        contact_list.adapter = adapter
        contact_list.layoutManager = LinearLayoutManager(this)
        adapter.updateItems(contactArray)

        val touchHelper = ItemTouchHelper(
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    adapter.array.removeAt(position)
                    adapter.notifyItemRemoved(position)
                }

            }
        )
        touchHelper.attachToRecyclerView(contact_list)
    }

    private fun addAction(){
        add_fab.setOnClickListener {
            val alert = AlertDialog.Builder(this, R.style.NewsDialogStyle)

            val inflater = layoutInflater.inflate(R.layout.alert_add, null)
            alert.setView(inflater)
            val image: EditText = inflater.findViewById(R.id.set_image)
            val firstName: EditText = inflater.findViewById(R.id.first_name_edit_text)
            val lastName: EditText = inflater.findViewById(R.id.last_name_edit_text)
            val email: EditText = inflater.findViewById(R.id.email_edit_text)
            val positiveButton: Button = inflater.findViewById(R.id.add_positive_button)
            val negativeButton: Button = inflater.findViewById(R.id.add_negative_button)
            val dialog = alert.create()
            negativeButton.setOnClickListener {
                dialog.dismiss()
            }
            positiveButton.setOnClickListener {
                addItem(image, firstName, lastName, email, dialog)
            }
            dialog.show()
        }
    }

    private fun addItem(imageEditText: EditText, firstNameEditText: EditText,
                        lastNameEditText: EditText, emailEditText: EditText, dialog: AlertDialog) {
        var error = 0
        if (isEmptyInputData(imageEditText, "Добавьте картинку")) error += 1
        if (isEmptyInputData(firstNameEditText, "Введите свое имя")) error += 1
        if (isEmptyInputData(lastNameEditText, "Введите свою фамилию")) error += 1
        if (isEmptyInputData(emailEditText, "Введите свой имейл")) error += 1

        if (error > 0) return

        val contact = Contact(imageEditText.text.toString() , firstNameEditText.text.toString(),
            lastNameEditText.text.toString(), emailEditText.text.toString())
        adapter.addItem(contact)
        dialog.dismiss()
    }

    private fun isEmptyInputData(view: EditText, message: String): Boolean {
        if (view.text.isNullOrEmpty()){
            view.error = message
            return true
        }
        return false
    }
}