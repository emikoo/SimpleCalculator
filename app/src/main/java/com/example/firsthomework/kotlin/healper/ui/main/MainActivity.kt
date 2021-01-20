package com.example.firsthomework.kotlin.healper.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.models.Name
import com.example.firsthomework.kotlin.healper.models.nameArray
import com.example.firsthomework.kotlin.healper.showToast
import com.example.firsthomework.kotlin.healper.ui.detail_name.DetailNameFragment
import com.example.firsthomework.kotlin.healper.ui.image_list.ImageListFragment
import com.example.firsthomework.kotlin.healper.ui.main.adapter.MainAdapter
import com.example.firsthomework.kotlin.healper.ui.main.adapter.MainViewPagerAdapter
import com.example.firsthomework.kotlin.healper.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainAdapter.OnItemClick {

    lateinit var adapter: MainViewPagerAdapter

//    + Создать фрагмент ProfileFragment
//    + Добавить его в bottomNavigation и в MainViewPagerAdapter (2)
//    + Добавить иконку профиля и заменить ее в bottomNavigationView
//    + Добавить в fragment_profile CircleImageView, TextView, TextView, Button (Иконка профиля, Имя, Описание, Кнопка подписаться)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager()
        setupBottomNavigationView()
    }

    override fun onItemClick(item: Name, position: Int) {
        val fragment = DetailNameFragment().apply {
            arguments = Bundle().apply { putString("yourItem", item.name) }
        }
        supportFragmentManager.beginTransaction().add(R.id.view_pager, fragment).addToBackStack(fragment.tag).commit()
        showToast(this, "Нажатый элемент ${item.name}")
    }

    private fun setupViewPager(){
        adapter = MainViewPagerAdapter(this)
        adapter.addFragment(ImageListFragment("IMAGE 1"))
        adapter.addFragment(ImageListFragment("IMAGE 2"))
        adapter.addFragment(ImageListFragment("IMAGE 3"))
        adapter.addFragment(ProfileFragment())
        view_pager.adapter = adapter
        view_pager.isUserInputEnabled = false
    }

    private fun setupBottomNavigationView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.image -> view_pager.setCurrentItem(0, false)
                R.id.image1 -> view_pager.setCurrentItem(1, false)
                R.id.image2 -> view_pager.setCurrentItem(2, false)
                R.id.profile -> view_pager.setCurrentItem(3, false)
            }
            true
        }
    }
}

