package com.example.firsthomework.kotlin.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.ui.cat.CatFragment
import com.example.firsthomework.kotlin.ui.dog.DogFragment
import com.example.firsthomework.kotlin.ui.favorities.FavoritePetsFragment
import com.example.firsthomework.kotlin.ui.pet.PetFragment
import com.example.firsthomework.kotlin.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //+Добавить новый фрагмент FavoritesPets
    //+Добавить новый элемент в bottom navigation view (сердечко)
    //+В layout добавить TextViw на весь экран с название Favorites pets

    lateinit var adapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigation()
        setupViewPager()
    }

    private fun setupViewPager() {
        adapter = MainViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(PetFragment())
        adapter.addFragment(FavoritePetsFragment())
        adapter.addFragment(ProfileFragment())
        view_pager.adapter = adapter
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.pets -> view_pager.setCurrentItem(0, false)
                R.id.favorites -> view_pager.setCurrentItem(1, false)
                R.id.profile -> view_pager.setCurrentItem(2, false)
            }
            true
        }
    }
}

