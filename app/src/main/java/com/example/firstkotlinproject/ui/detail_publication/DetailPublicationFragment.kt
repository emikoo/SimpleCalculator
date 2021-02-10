package com.example.firstkotlinproject.ui.detail_publication

import android.R.attr
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firstkotlinproject.models.Images
import com.example.firstkotlinproject.models.Publication
import com.example.firstkotlinproject.ui.profile.adapter.ClickListener
import com.example.firstkotlinproject.ui.profile.adapter.ProfileAdapter
import kotlinx.android.synthetic.main.fragment_detail_publication.*


class DetailPublicationFragment : Fragment(), ClickListener {

    lateinit var adapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_publication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getSerializable("publication") as Publication

        Glide.with(requireContext()).load(data.image).into(icon_civ)
        name_tv.text = data.name
        setupRV()
        //adapter.addItems(mutableListOf(data))
    }

    private fun setupRV() {
        adapter = ProfileAdapter(this)
        images_rv.adapter = adapter
        images_rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onItemClick(item: Images) {
    }
}