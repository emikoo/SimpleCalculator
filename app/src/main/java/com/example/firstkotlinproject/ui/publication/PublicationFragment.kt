package com.example.firstkotlinproject.ui.publication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsthomework.R
import com.example.firstkotlinproject.helper.showToast
import com.example.firstkotlinproject.models.Publication
import com.example.firstkotlinproject.ui.main.MainRepository
import com.example.firstkotlinproject.ui.publication.adapter.PublicationAdapter
import kotlinx.android.synthetic.main.fragment_publication.*

interface RequestResult {
    fun onFailure(t: Throwable)
    fun <T>onSuccess(result: T)
}
class PublicationFragment : Fragment(), PublicationAdapter.ClickListener, RequestResult {

    private lateinit var adapter: PublicationAdapter
    private var publicationsArray: MutableList<Publication> = mutableListOf()
    private lateinit var repository: MainRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_publication, container, false)
    }

    override fun onResume() {
        super.onResume()
        repository = MainRepository(this)
        repository.fetchPublications()
    }

    override fun onFailure(t: Throwable) {
        showToast(requireContext(), t.message.toString())
    }

    override fun <T>onSuccess(result: T) {
        publicationsArray = result as MutableList<Publication>
        adapter.addItems(publicationsArray)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = PublicationAdapter(this)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun updateItems() {
        adapter.addItems(publicationsArray)
    }

    override fun onItemClick(item: Publication) {
    }

    override fun onLikeClick(item: Publication, position: Int) {
//        changeState(item, publicationsArray)
//        adapter.update(position)
    }

    override fun onCommentClick(item: Publication) {
    }

    override fun onDirectClick(item: Publication) {
    }
}