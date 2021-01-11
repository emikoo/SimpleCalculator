package com.example.firsthomework.kotlin.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.ui.cat.CatFragment
import com.example.firsthomework.kotlin.ui.dog.DogFragment
import com.example.firsthomework.kotlin.ui.pet.PetFragment
import com.example.firsthomework.kotlin.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*!!Подготовиться к ежемесячному экзамену по темам:
       Recycler, Snackbar,
       Dialogs, toolbar, fragment,
       viewpager, tabLayout,
       bottomNavigationView
     */
     //+Если есть номер телефона в поле phoneNumber тогда сделать переход на звонилку устройства иначе отобразить сообщение "Номер отсутствует"
     //+Упростить 2 метода в ProfileFragment - setEditState(), updateEditingViews()
     //+(Доп) отказаться от переменной isEdit в ProfileFragment

    private var profileFragment = ProfileFragment()
    private var petFragment = PetFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        addStartFragment()
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.pets -> navigateFragment(petFragment)
                R.id.profile -> navigateFragment(profileFragment)
                else -> false
            }
        }
    }

    private fun navigateFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, fragment).commit()
        return true
    }

    private fun addStartFragment() {
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, PetFragment()).commit()
    }
}

