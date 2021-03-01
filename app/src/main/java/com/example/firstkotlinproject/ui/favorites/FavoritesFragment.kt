package com.example.firstkotlinproject.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.BinderThread
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firsthomework.R
import com.example.firstkotlinproject.data.models.Publication
import com.example.firstkotlinproject.data.models.changeState
import com.example.firstkotlinproject.ui.main.MainRepository
import com.example.firstkotlinproject.ui.publication.RequestResult
import com.example.firstkotlinproject.ui.publication.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment(), PublicationAdapter.ClickListener, RequestResult {

    private lateinit var adapter: PublicationAdapter
    private lateinit var repository: MainRepository
    private var publicationsArray = mutableListOf<Publication>()

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
        repository = MainRepository(this)
        repository.fetchFavoritePublications()
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
        changeState(item)
        repository.updateChangeFavoriteState(item)
        adapter.removeItem(position)
    }

    override fun onCommentClick(item: Publication) {
    }

    override fun onDirectClick(item: Publication) {
    }

    override fun onFailure(t: Throwable) {
    }

    override fun <T> onSuccess(result: T) {
        publicationsArray = result as MutableList<Publication>
        adapter.addItems(publicationsArray)
    }
}