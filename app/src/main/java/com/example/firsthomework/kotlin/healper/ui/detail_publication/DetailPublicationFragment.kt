package com.example.firsthomework.kotlin.healper.ui.detail_publication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.models.Publication
import com.example.firsthomework.kotlin.healper.models.changeState
import com.example.firsthomework.kotlin.healper.models.imageArray
import com.example.firsthomework.kotlin.healper.models.publicationsArray
import com.example.firsthomework.kotlin.healper.ui.publication.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_detail_publication.*

class DetailPublicationFragment : Fragment() {

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

        Glide.with(requireContext()).load(data.icon).into(icon_civ)
        name_tv.text = data.name
    }
}