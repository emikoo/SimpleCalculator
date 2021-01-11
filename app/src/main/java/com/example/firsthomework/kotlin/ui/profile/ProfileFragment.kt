package com.example.firsthomework.kotlin.ui.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.SharedPreference
import com.example.firsthomework.kotlin.healper.showToast
import kotlinx.android.synthetic.main.alert_add.view.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var shared: SharedPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupSharedPreference()
        setupViews()
        callAction()
        editAction()
    }

    private fun setupSharedPreference() {
        shared = SharedPreference(requireContext())
    }

    private fun setupViews() {
        Glide.with(image.context)
            .load(shared.image)
            .into(image)
        name.setText(shared.name)
        surname.setText(shared.surname)
        phone_number.setText(shared.phoneNumber)
    }

    private fun callAction() {
        call.setOnClickListener {
            val phoneNo = phone_number.text.toString()
            if (!TextUtils.isEmpty(phoneNo)) {
                val dial = "tel:$phoneNo"
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(dial)))
            } else {
                showToast(requireContext(), "Enter a phone number")
            }
        }
    }

    private fun editAction() {
        toolbar_edit.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.edit -> {
                    setEditState()
                    updateEditingViews()
                    true
                } else -> false
            }
        }
    }

    private fun setEditState() {
        name.isEnabled = !name.isEnabled
        surname.isEnabled = !surname.isEnabled
        phone_number.isEnabled = !phone_number.isEnabled
    }

    private fun updateEditingViews() {
        if (name.isEnabled){
            shared.name = name.text.toString()
            shared.surname = surname.text.toString()
            shared.phoneNumber = phone_number.text.toString()
        }
    }
}