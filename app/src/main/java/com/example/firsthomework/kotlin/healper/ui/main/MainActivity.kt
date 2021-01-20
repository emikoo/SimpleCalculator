package com.example.firsthomework.kotlin.healper.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.ui.favorites.FavoritesFragment
import com.example.firsthomework.kotlin.healper.ui.publication.PublicationFragment
import com.example.firsthomework.kotlin.healper.ui.main.adapter.MainViewPagerAdapter
import com.example.firsthomework.kotlin.healper.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainViewPagerAdapter

//    + Добавить фрагмент FavoritesFragment
//    + Добавить layout для FavoritesFragment
//    + Заменить иконку где у нас посты на иконку постов, а не сердце
//    + в BottomMenu поменять 3 категории по их названию с (image, image, Профиль) на (Публикации, Избранно, Профиль)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
        setupBottomNavigationView()
    }

    private fun setupViewPager(){
        adapter = MainViewPagerAdapter(this)
        adapter.addFragment(PublicationFragment())
        adapter.addFragment(FavoritesFragment())
        adapter.addFragment(ProfileFragment())
        view_pager.adapter = adapter
        view_pager.isUserInputEnabled = false
    }

    private fun setupBottomNavigationView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.image -> changeCurrentItem(0)
                R.id.image1 -> changeCurrentItem(1)
                R.id.profile -> changeCurrentItem(2)
            }
            true
        }
    }

    private fun changeCurrentItem(position: Int) {
        view_pager.setCurrentItem(position, false)
    }
}

