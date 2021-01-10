package com.example.firsthomework.kotlin.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.ui.cat.CatFragment
import com.example.firsthomework.kotlin.ui.dog.DogFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //+Прочитать про TabLayout
    //+Прочитать про ViewPager
    //+Создать DogAdapter
    //+Создать в файле Cat переменную dogArray и добавить в неё значения
    //+Создат DogDetailActivity и для него layout
    //+Отрисовать в DogFragment dogArray и сделать переход в DogDetailActivity
    //+Отрисовать все значения в DogDetailActivity

    private val catFragment =
        CatFragment()
    private val dogFragment =
        DogFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        addStartFragment()
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.cat -> navigateFragment(catFragment)
                R.id.dog -> navigateFragment(dogFragment)
                else -> false
            }
        }
    }

    private fun navigateFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.container_fragment, fragment).commit()
        return true
    }

    private fun addStartFragment() {
        supportFragmentManager.beginTransaction().add(R.id.container_fragment, catFragment).commit()
    }
}

