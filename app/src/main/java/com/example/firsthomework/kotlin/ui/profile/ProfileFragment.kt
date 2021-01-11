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
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var shared: SharedPreference
    var isEdit: Boolean = false

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
            .load("https://knowhow.pp.ua/wp-content/uploads/2020/05/unnamed-2.jpg")
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
                    isEdit = !isEdit
                    getEditFill(isEdit)
                    true
                } else -> false
            }
        }
    }

    private fun getEditFill(state: Boolean?) {
        if (state!!) {
            name.isEnabled = true
            surname.isEnabled = true
            phone_number.isEnabled = true
        } else {
            var nameEdited = name.text.toString()
            var surnameEdited = surname.text.toString()
            var phoneNumber = phone_number.text.toString()

            shared.name = nameEdited
            shared.surname = surnameEdited
            shared.phoneNumber = phoneNumber

            name.isEnabled = false
            surname.isEnabled = false
            phone_number.isEnabled = false
        }
    }
}