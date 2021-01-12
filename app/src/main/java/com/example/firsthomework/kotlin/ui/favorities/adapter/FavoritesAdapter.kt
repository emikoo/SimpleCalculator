package com.example.firsthomework.kotlin.ui.favorities.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.models.Pets
import com.example.firsthomework.kotlin.ui.pet_detail.getLikeImage

class FavoritesAdapter(private val listener: OnItemClick) : RecyclerView.Adapter<FavoritesViewHolder>() {

    private var array = mutableListOf<Pets>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorites, parent, false)
        return FavoritesViewHolder(view)
    }

    fun addItems(list: MutableList<Pets>) {
        array = list
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        array.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, array.size)
    }

    fun restoreItem(position: Int, item: Pets) {
        array.add(position, item)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, array.size)
    }

    override fun getItemCount(): Int {
        return array.count()
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val item = array[position]
        holder.bind(item)
        holder.like.setOnClickListener {
            listener.onLikeClick(position, item)
        }
    }

    interface OnItemClick {
        fun onLikeClick(position: Int, item: Pets)
    }
}

class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val image: ImageView = itemView.findViewById(R.id.image)
    val title: TextView = itemView.findViewById(R.id.title)
    val subtitle: TextView = itemView.findViewById(R.id.subtitle)
    val like: ImageButton = itemView.findViewById(R.id.like)

    fun bind(item: Pets) {
        title.text = item.name
        subtitle.text = item.description
        like.setImageResource(getLikeImage(item.isLiked))

        Glide.with(image.context)
            .load(item.image)
            .into(image)
    }

}