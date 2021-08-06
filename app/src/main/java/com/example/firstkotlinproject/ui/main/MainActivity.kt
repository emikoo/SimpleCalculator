package com.example.firstkotlinproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firsthomework.R
import com.example.firstkotlinproject.ui.favorites.FavoritesFragment
import com.example.firstkotlinproject.ui.main.adapter.MainViewPagerAdapter
import com.example.firstkotlinproject.ui.profile.ProfileFragment
import com.example.firstkotlinproject.ui.publication.PublicationFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var adapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
        setupBottomNavigationView()
    }

    private fun setupViewPager() {
        adapter = MainViewPagerAdapter(this)
        adapter.addFragment(PublicationFragment())
        adapter.addFragment(FavoritesFragment())
        adapter.addFragment(ProfileFragment())
        view_pager.adapter = adapter
        view_pager.offscreenPageLimit = 3
        view_pager.isEnabled = false
        view_pager.isUserInputEnabled = false
    }

    private fun setupBottomNavigationView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.image -> changeCurrentItem(0)
                R.id.favorite -> changeCurrentItem(1)
                R.id.profile -> changeCurrentItem(2)
            }
            true
        }
    }

    private fun changeCurrentItem(position: Int) {
        view_pager.setCurrentItem(position, false)
        
    }


}

