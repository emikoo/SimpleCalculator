package com.example.firstkotlinproject.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firstkotlinproject.models.Publication
import com.example.firstkotlinproject.ui.detail_publication.DetailPublicationFragment
import com.example.firstkotlinproject.ui.profile.adapter.ClickListener
import com.example.firstkotlinproject.ui.profile.adapter.ProfileAdapter
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ClickListener {

    lateinit var adapter: ProfileAdapter
    val COUNT_OF_GRID = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViews()
    }

    private fun setupRecyclerView() {
        adapter = ProfileAdapter(this)
        recycler_view_profile.adapter = adapter
        recycler_view_profile.layoutManager = GridLayoutManager(requireContext(), COUNT_OF_GRID)
//        adapter.addItems(userPublications())
    }

    private fun setupViews() {
//        val user = userPublications().last()
//        Glide.with(requireContext()).load(user.icon).into(image_civ)
//        name_tv.text = user.name
//        description_tv.text = user.phoneNumber
    }

//    private fun userPublications() : MutableList<Publication> = publicationsArray.filter { it.id == 7 } as MutableList<Publication>

    override fun onItemClick(item: Publication) {
        val fragment = DetailPublicationFragment()
        val bundle = Bundle()
        bundle.putSerializable("publication", item)
        fragment.arguments = bundle
        activity?.supportFragmentManager?.beginTransaction()?.add(R.id.main, fragment)?.addToBackStack(fragment.tag)?.commit()
    }
}