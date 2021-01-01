package com.example.firsthomework.ui.contacts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firsthomework.R
import com.example.firsthomework.ui.detail_contact.DetailContactActivity
import com.example.firsthomework.ui.healper.Contact
import com.example.firsthomework.ui.healper.ItemSimpleTouch
import com.example.firsthomework.ui.healper.contactArray
import com.example.firsthomework.ui.healper.showActionSnackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ContactAdapter.OnItemClick {
    //+1. Исправить удаление элемента
    //+2. Вызвать отображение  SnackBar с возможностью востановить элемент
    //+3. Реализовать востановление элемента

    lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAdapter()
        addAction()
    }

    private fun setupAdapter() {
        adapter = ContactAdapter(this)
        contact_list.adapter = adapter
        contact_list.layoutManager = LinearLayoutManager(this)
        adapter.updateItems(contactArray)

        val swipeHandler = object : ItemSimpleTouch(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val item = contactArray[position]
                val name = item.firstName
                adapter.deleteItem(position)
                adapter.notifyDataSetChanged()
                //Вызвать отображение  SnackBar с возможностью востановить элемент
                showActionSnackbar(contact_list, "Вы удалили $name", "Востановить",
                    {adapter.restoreItem(item,position)}, this@MainActivity)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(contact_list)
    }

    private fun addAction(){
        add_fab.setOnClickListener {
            showAddingMemberActionDialog()
        }
    }

    fun showAddingMemberActionDialog(){
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

    override fun onItemClick(item: Contact) {
        val intent = Intent(this, DetailContactActivity::class.java)
        startActivity(intent)
    }
}