package com.example.firsthomework.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.ui.models.dicaprio
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupViews()
        editAction()
    }

    private fun setupViews(){
        Glide.with(this)
            .load(dicaprio.image)
            .placeholder(R.drawable.ic_contact)
            .into(image)
        name.text = dicaprio.name
        email.text = dicaprio.email
        age.text = dicaprio.age
        bio.text = dicaprio.bio
    }

    private fun editAction(){
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.edit -> {
                    val intent = Intent(activity, EditProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}