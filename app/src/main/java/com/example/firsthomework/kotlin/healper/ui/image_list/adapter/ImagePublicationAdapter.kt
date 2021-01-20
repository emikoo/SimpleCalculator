package com.example.firsthomework.kotlin.healper.ui.image_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import kotlinx.android.synthetic.main.item_image.view.*

class ImagePublicationAdapter : RecyclerView.Adapter<ImagePublicationViewHolder>() {

    private var urls = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagePublicationViewHolder {
        return ImagePublicationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return urls.count()
    }

    override fun onBindViewHolder(holder: ImagePublicationViewHolder, position: Int) {
        val item = urls[position]
        holder.bind(item)

    }

    fun addItems(items: MutableList<String>) {
        urls = items
        notifyDataSetChanged()
    }
}


class ImagePublicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(url: String) {
        Glide.with(itemView.image_iv.context).load(url).into(itemView.image_iv)
    }
}