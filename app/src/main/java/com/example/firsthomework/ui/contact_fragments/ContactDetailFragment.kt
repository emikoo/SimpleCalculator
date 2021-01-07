package com.example.firsthomework.ui.contact_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.ui.healper.Contact
import com.example.firsthomework.ui.healper.SharedPreference
import com.example.firsthomework.ui.healper.showToast
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_contact_detail.*
import kotlinx.android.synthetic.main.fragment_contact_detail.close_toolbar

class ContactDetailFragment : Fragment() {
    private lateinit var contact: Contact

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        contact = arguments?.getSerializable("item") as Contact
        showToast(requireContext()," ${contact.firstName} ${contact.lastName}")
        setupViews()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onToolbarClicked()
    }

    private fun setupViews(){
        Glide.with(image)
            .load(contact.image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .into(image)

        firstName.text = contact.firstName
        lastName.text = contact.lastName
        email.text = contact.email
    }

    private fun onToolbarClicked(){
        close_toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
        left_toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }
}