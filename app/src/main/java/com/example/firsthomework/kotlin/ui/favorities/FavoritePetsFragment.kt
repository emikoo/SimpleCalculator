package com.example.firsthomework.kotlin.ui.favorities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.showActionSnackbar
import com.example.firsthomework.kotlin.models.*
import com.example.firsthomework.kotlin.ui.favorities.adapter.FavoritesAdapter
import kotlinx.android.synthetic.main.fragment_favorite_pets.*

class FavoritesPetsFragment : Fragment(), FavoritesAdapter.OnItemClick {

    //activity & fragment = VIEW
    lateinit var adapter: FavoritesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_pets, container, false)
    }

    override fun onResume() {
        super.onResume()
        updateItems()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = FavoritesAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.adapter = adapter
    }

    private fun updateItems() {
        adapter.addItems(getFavoriteArray())
    }

    override fun onLikeClick(position: Int, item: Pets) {
        adapter.removeItem(position)
        changeItems(item)
        showActionSnackbar(recycler_view,
            "Вы удалили из избранного ${item.name}",
            "Восстановить", {
            adapter.restoreItem(position, item)
            changeItems(item) }, requireContext())
    }

    private fun changeItems(item: Pets) {
        changeState(item, dogArray)
        changeState(item, catArray)
    }
}