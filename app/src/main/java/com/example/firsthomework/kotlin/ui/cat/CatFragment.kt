package com.example.firsthomework.kotlin.ui.cat

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.models.Pets
import com.example.firsthomework.kotlin.models.catArray
import com.example.firsthomework.kotlin.ui.cat.adapter.PetAdapter
import com.example.firsthomework.kotlin.ui.pet_detail.PetDetailActivity
import kotlinx.android.synthetic.main.fragment_cat.*

class CatFragment : Fragment(), PetAdapter.OnItemClick {

    lateinit var adapter: PetAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter(){
        adapter = PetAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onResume() {
        super.onResume()
        updateItems()
    }

    private fun updateItems() {
        adapter.update(catArray)
    }

    override fun onItemCLick(item: Pets) {
        val intent = Intent(activity, PetDetailActivity::class.java)
        intent.putExtra("pet", item)
        startActivity(intent)
    }
}