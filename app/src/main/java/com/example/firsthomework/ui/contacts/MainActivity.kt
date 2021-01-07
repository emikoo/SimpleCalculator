package com.example.firsthomework.ui.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.R
import com.example.firsthomework.ui.contact_fragments.ContactFragment


class MainActivity : AppCompatActivity() {
    //+3. Прочитать про toolbar
    //+4. ContactDetailFragment добавить тулбар, и добавить кнопку и сделать удаление элемента из contactArray и закрывать активити.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_fragment, ContactFragment())
            .commit()
    }
}

