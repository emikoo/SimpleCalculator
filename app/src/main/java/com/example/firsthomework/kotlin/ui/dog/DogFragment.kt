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
import com.example.firsthomework.kotlin.ui.cat.adapter.PetAdapter
import com.example.firsthomework.kotlin.ui.pet_detail.PetDetailActivity
import kotlinx.android.synthetic.main.fragment_dog.*

class DogFragment : Fragment(), PetAdapter.OnItemClick {

    private lateinit var adapter: PetAdapter
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
        adapter = PetAdapter(this)
        recycler_view_dog.adapter = adapter
        recycler_view_dog.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        updateItems()
    }

    private fun updateItems() {
        adapter.update(dogArray)
    }

    override fun onItemCLick(item: Pets) {
        val intent = Intent(activity, PetDetailActivity::class.java)
        intent.putExtra("pet", item)
        startActivity(intent)
    }
}