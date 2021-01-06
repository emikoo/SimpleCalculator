package com.example.firsthomework.ui.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.ui.healper.Contact
import com.example.firsthomework.ui.healper.contactArray

class ContactAdapter(private var listener: OnItemClick) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    var array = mutableListOf<Contact>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.count()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = array[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            listener.onItemClick(item)
        }
    }

    fun updateItems(items: MutableList<Contact>) {
        array = items
        notifyDataSetChanged()
    }

    fun addItem(item: Contact) {
        array.add(item)
        notifyItemInserted(array.lastIndex)
    }

    fun deleteItem(position: Int){
        array.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    fun restoreItem(item: Contact, position: Int){
        array.add(position, item)
        notifyItemRangeChanged(position, itemCount)
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val firstName: TextView = itemView.findViewById(R.id.firstName)
        private val lastName: TextView = itemView.findViewById(R.id.lastName)
        private val email: TextView = itemView.findViewById(R.id.email)

        fun bind(item: Contact) {
            Glide.with(image.context)
                .load(item.image)
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(image)
            firstName.text = item.firstName
            lastName.text = item.lastName
            email.text = item.email
        }
    }

    interface OnItemClick {
        fun onItemClick(item: Contact)
    }

}