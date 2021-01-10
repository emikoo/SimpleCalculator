package com.example.firsthomework.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.ui.contacts.MainActivity
import com.example.firsthomework.ui.models.dicaprio
import kotlinx.android.synthetic.main.activity_edit_profile.*


class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        setupViews()
        editAction()
    }

    private fun setupViews(){
        Glide.with(this)
            .load(dicaprio.image)
            .placeholder(R.drawable.ic_contact)
            .into(image)
        name_edit_text.setText(dicaprio.name)
        email_edit_text.setText(dicaprio.email)
        age_edit_text.setText(dicaprio.age)
        bio_edit_text.setText(dicaprio.bio)
    }

    private fun editAction(){
        edit_toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.edit -> {
                    saveChanges()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("flag", true)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun saveChanges(){
        val name = name_edit_text.text.toString()
        val email = email_edit_text.text.toString()
        val age = age_edit_text.text.toString()
        val bio = bio_edit_text.text.toString()

        dicaprio.name = name
        dicaprio.email = email
        dicaprio.age = age
        dicaprio.bio = bio
    }
}