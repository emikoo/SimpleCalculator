package com.example.firstkotlinproject.ui.profile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firstkotlinproject.models.Publication
import kotlinx.android.synthetic.main.item_profile.view.*

class ProfileAdapter(val listener: ClickListener) : RecyclerView.Adapter<ProfileViewHolder>() {

    var items = mutableListOf<Publication>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item.randomImage)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    fun addItems(items: MutableList<Publication>) {
        this.items = items
        notifyDataSetChanged()
    }

}

class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(imageUrl: String){
        Glide.with(itemView.context).load(imageUrl).into(itemView.icon)
    }
}

interface ClickListener {
    fun onItemClick(item: Publication)
}