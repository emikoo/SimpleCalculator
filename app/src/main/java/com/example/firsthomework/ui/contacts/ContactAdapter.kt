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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contacts, parent, false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactArray.count()
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contactArray[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            listener.onItemClick(item)
        }
    }

    fun addItem(item: Contact) {
        contactArray.add(item)
        notifyItemInserted(contactArray.lastIndex)
    }

    fun deleteItem(position: Int){
        contactArray.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    fun restoreItem(item: Contact, position: Int){
        contactArray.add(position, item)
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