package com.example.firsthomework.ui.contact_fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firsthomework.R
import com.example.firsthomework.ui.contacts.ContactAdapter
import com.example.firsthomework.ui.healper.*
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment(), ContactAdapter.OnItemClick, OnAddEditListener {

    lateinit var adapter: ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupAdapter()
        addAction()
        onToolbarClicked()
    }

    private fun setupAdapter(){
        adapter = ContactAdapter(this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())

        val swipeHandler = object : ItemSimpleTouch(requireContext()){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val item = contactArray[position]
                adapter.deleteItem(position)
                adapter.notifyDataSetChanged()
                showActionSnackbar(fab,
                    "Вы удалили ${item.firstName} ${item.lastName}",
                    "Востановить",
                    {adapter.restoreItem(item,position)},
                    requireContext())
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler_view)
    }

    override fun onItemClick(item: Contact) {
        val bundle = Bundle()
        bundle.putSerializable("item", item)

        val fragment = ContactDetailFragment()
        fragment.arguments = bundle

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container_fragment, fragment, fragment.tag)
            ?.addToBackStack(fragment.tag)
            ?.commit()
    }

    private fun addAction() {
        fab.setOnClickListener {
            activity?.let {
                ShowAddEditingDialog(it, "Добавление контакта", this, 0).show()
            }
        }
    }

    override fun addEditingDialog(type: Int, contact: Contact) {
        adapter.addItem(contact)
    }

    private fun onToolbarClicked(){
        close_toolbar.setNavigationOnClickListener {
            activity?.finish()
        }
    }
}