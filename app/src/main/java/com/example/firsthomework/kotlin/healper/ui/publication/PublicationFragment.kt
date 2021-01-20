package com.example.firsthomework.kotlin.healper.ui.publication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.models.Publication
import com.example.firsthomework.kotlin.healper.models.publicationsArray
import com.example.firsthomework.kotlin.healper.ui.publication.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_publication.*

class PublicationFragment : Fragment(), PublicationAdapter.ClickListener {

    private lateinit var adapter: PublicationAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_publication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter =
            PublicationAdapter(
                this,
                requireActivity()
            )
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = adapter
        adapter.addItems(publicationsArray)
    }

    override fun onItemClick(item: Publication) {

    }
}