package com.example.firstkotlinproject.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firstkotlinproject.helper.showToast
import com.example.firstkotlinproject.data.models.Images
import com.example.firstkotlinproject.data.models.Publication
import com.example.firstkotlinproject.ui.main.MainRepository
import com.example.firstkotlinproject.ui.profile.adapter.ClickListener
import com.example.firstkotlinproject.ui.profile.adapter.ProfileAdapter
import com.example.firstkotlinproject.ui.publication.RequestResult
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ClickListener, RequestResult {

    lateinit var adapter: ProfileAdapter
    val COUNT_OF_GRID = 3
    private lateinit var repository: MainRepository


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
    }

    private fun setupRecyclerView() {
        adapter = ProfileAdapter(this)
        recycler_view_profile.adapter = adapter
        recycler_view_profile.layoutManager = GridLayoutManager(requireContext(), COUNT_OF_GRID)
    }

    override fun onResume() {
        super.onResume()
        repository = MainRepository(this)
        repository.fetchProfile()
    }

    override fun onItemClick(item: Images) {
//        val fragment = DetailPublicationFragment()
//        val bundle = Bundle()
//        bundle.putSerializable("publication", item)
//        fragment.arguments = bundle
//        activity?.supportFragmentManager?.beginTransaction()?.add(R.id.main, fragment)?.addToBackStack(fragment.tag)?.commit()
    }
    override fun onFailure(t: Throwable) {
        showToast(requireContext(), t.message.toString())
    }

    override fun <T>onSuccess(result: T) {
        val user = result as Publication
        setupViews(user)
    }

    private fun setupViews(user: Publication) {
        Glide.with(requireContext()).load(user.image).into(image_civ)
        name_tv.text = user.name
        description_tv.text = user.phoneNumber

        user.images?.let { adapter.addItems(it) }
    }
}