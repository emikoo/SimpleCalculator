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
import com.example.firsthomework.kotlin.ui.pet_detail.getLikeImage

class PetAdapter(private var listener: OnItemClick) : RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    private var array = mutableListOf<Pets>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.count()
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
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

    class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.findViewById(R.id.image_pet)
        private val title: TextView = itemView.findViewById(R.id.title_pet)
        private val subtitle: TextView = itemView.findViewById(R.id.subtitle_pet)
        val like: ImageButton = itemView.findViewById(R.id.like_pet)

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