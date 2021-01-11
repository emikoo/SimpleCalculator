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
import com.example.firsthomework.kotlin.ui.cat.adapter.CatAdapter
import com.example.firsthomework.kotlin.ui.cat_detail.CatDetailActivity
import kotlinx.android.synthetic.main.fragment_cat.*

class CatFragment : Fragment(), CatAdapter.OnItemClick {

    private lateinit var adapter: CatAdapter
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
        adapter = CatAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        adapter.update(catArray)
    }

    override fun onItemCLick(item: Pets) {
        val intent = Intent(activity, CatDetailActivity::class.java)
        intent.putExtra("cat", item)
        startActivity(intent)
    }
}