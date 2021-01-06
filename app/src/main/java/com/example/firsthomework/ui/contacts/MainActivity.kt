package com.example.firsthomework.ui.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.R
import com.example.firsthomework.ui.contact_fragments.ContactFragment
import com.example.firsthomework.ui.healper.SharedPreference
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //+1. Прочитать про fragments
    //+2. Прочитать про класс Dialog
    //+3. Исправить пропавшие кнопки
    //+4. Прочитать про toolbar
    //+5. (Extra) ContactDetailFragment добавить тулбар, и добавить кнопку и сделать удаление элемента из contactArray
    //+позволять польщоваться или отображать тулбар только на ContactDetailFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container_fragment, ContactFragment())
            .commit()

    }
}

