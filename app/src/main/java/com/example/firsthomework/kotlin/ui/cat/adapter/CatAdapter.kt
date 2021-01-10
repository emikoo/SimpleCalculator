package com.example.firsthomework.kotlin.ui.cat.adapter

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

class CatAdapter(private var listener: OnItemClick) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    private var array = mutableListOf<Pets>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatAdapter.CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.count()
    }

    override fun onBindViewHolder(holder: CatAdapter.CatViewHolder, position: Int) {
        val item = array[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemCLick(item)
        }
        holder.like.setOnClickListener {
            val like = !array[position].isLiked
            array[position].isLiked = like
            holder.like.setImageResource(getLikeImage(like))
        }
    }

    fun update(item: MutableList<Pets>) {
        array = item
        notifyDataSetChanged()
    }

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.findViewById(R.id.image)
        private val title: TextView = itemView.findViewById(R.id.title)
        private val subtitle: TextView = itemView.findViewById(R.id.subtitle)
        val like: ImageButton = itemView.findViewById(R.id.like)

        fun bind(item: Pets) {
            Glide.with(image.context)
                .load(item.image)
                .into(image)
            title.text = item.name
            subtitle.text = item.description

            like.setImageResource(getLikeImage(item.isLiked))
        }
    }

    interface OnItemClick {
        fun onItemCLick(item: Pets)
    }
}
    fun getLikeImage(state: Boolean) = if (state)  R.drawable.ic_liked
    else R.drawable.ic_unliked