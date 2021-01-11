package com.example.firsthomework.kotlin.ui.dog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.models.Pets
import com.example.firsthomework.kotlin.models.dogArray
import com.example.firsthomework.kotlin.ui.cat.adapter.DogAdapter
import com.example.firsthomework.kotlin.ui.dog_detail.DogDetailActivity
import kotlinx.android.synthetic.main.fragment_cat.recycler_view
import kotlinx.android.synthetic.main.fragment_dog.*

class DogFragment : Fragment(), DogAdapter.OnItemClick {

    private lateinit var adapter: DogAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = DogAdapter(this)
        recycler_view_dog.adapter = adapter
        recycler_view_dog.layoutManager = LinearLayoutManager(requireContext())
        adapter.update(dogArray)
    }

    override fun onItemCLick(item: Pets) {
        val intent = Intent(activity, DogDetailActivity::class.java)
        intent.putExtra("dog", item)
        startActivity(intent)
    }
}