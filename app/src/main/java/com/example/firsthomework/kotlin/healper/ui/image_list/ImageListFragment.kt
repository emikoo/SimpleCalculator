package com.example.firsthomework.kotlin.healper.ui.image_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.ui.image_list.adapter.ImageListViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_image_list.*

class ImageListFragment(private val fragmentTitle: String) : Fragment() {

    lateinit var adapter: ImageListViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv.text = fragmentTitle
        setupViewPager()
    }

    private fun setupViewPager() {
        if (fragmentTitle != "IMAGE 1") return
        adapter = ImageListViewPagerAdapter(childFragmentManager)
        adapter.addFragment(ImageCarouselFragment("https://i1.sndcdn.com/artworks-twVuPijgKdMZwLOo-GAzEuQ-t500x500.jpg"))
        adapter.addFragment(ImageCarouselFragment("https://i1.sndcdn.com/avatars-nwffhCdGSzMy9IY1-EruAgA-t240x240.jpg"))
        adapter.addFragment(ImageCarouselFragment("https://i1.sndcdn.com/artworks-000204747428-j19cos-t500x500.jpg"))
        adapter.addFragment(ImageCarouselFragment("https://e-talentbank.co.jp/wp-content/uploads/2019/08/6673c67b52df1a90ac381fba4f80ca84-1600x1600.png"))
        adapter.addFragment(ImageCarouselFragment("https://static.wikia.nocookie.net/vocaloid/images/f/f4/Seeeeecun_icon.jpg/revision/latest?cb=20181222132429"))
        view_pager.adapter = adapter
    }
}