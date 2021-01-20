package com.example.firsthomework.kotlin.healper.ui.image_list.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ImageListViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private val fragments = mutableListOf<Fragment>()

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.count()
    }


}