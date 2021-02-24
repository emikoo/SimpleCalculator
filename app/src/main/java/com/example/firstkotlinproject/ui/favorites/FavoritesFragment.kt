package com.example.firstkotlinproject.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firstkotlinproject.data.models.Publication
import com.example.firstkotlinproject.ui.publication.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment(), PublicationAdapter.ClickListener {

    private lateinit var adapter: PublicationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
 //       updateItems()
    }

    private fun setupRecyclerView() {
        adapter = PublicationAdapter(this)
        favorite_rv.adapter = adapter
        favorite_rv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun updateItems() {
 //       adapter.addItems(getFavoriteArray())
    }

    override fun onItemClick(item: Publication) {
    }

    override fun onLikeClick(item: Publication, position: Int) {
//        adapter.removeItem(position)
//        changeState(item)
//        showActionSnackbar(favorite_rv,
//            "Вы удалили из избранного ${item.name}",
//            "Восстановить", {
//                adapter.restoreItem(position, item)
//                changeState(item)
//            }, requireContext()
//        )
    }

    override fun onCommentClick(item: Publication) {
    }

    override fun onDirectClick(item: Publication) {
    }
}