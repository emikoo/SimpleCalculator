package com.example.firsthomework.kotlin.healper.ui.publication.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.models.Publication
import com.example.firsthomework.kotlin.healper.ui.image_list.adapter.ImagePublicationAdapter
import kotlinx.android.synthetic.main.item_main.view.*

class PublicationAdapter(private val listener: ClickListener, private val activity: Activity) : RecyclerView.Adapter<PublicationViewHolder>() {

    private var items = mutableListOf<Publication>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        return PublicationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: PublicationViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, activity)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
        holder.itemView.like_btn.setOnClickListener {
            listener.onLikeClick(item, position)
            holder.itemView.like_btn.setImageResource(getLikeImage(item.isFavorite))
        }
        holder.itemView.comment_btn.setOnClickListener {
            listener.onCommentClick(item)
        }
        holder.itemView.direct_btn.setOnClickListener {
            listener.onDirectClick(item)
        }
    }

    fun addItems(items: MutableList<Publication>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, items.size)
    }

    fun restoreItem(position: Int, item: Publication) {
        items.add(position, item)
        notifyItemInserted(position)
        notifyItemRangeChanged(position, items.size)
    }

    fun update(position: Int) {
        notifyItemChanged(position)
    }

    interface ClickListener {
        fun onItemClick(item: Publication)
        fun onLikeClick(item: Publication, position: Int)
        fun onCommentClick(item: Publication)
        fun onDirectClick(item: Publication)
    }
}

class PublicationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Publication, activity: Activity) {
        Glide.with(itemView.context).load(item.icon).into(itemView.icon_civ)
        itemView.name_tv.text = item.name
        itemView.like_btn.setImageResource(getLikeImage(item.isFavorite))
        setupRecyclerView(item.image, activity)
    }

    private fun setupRecyclerView(items: MutableList<String>, activity: Activity) {
        val adapter = ImagePublicationAdapter()
        val snapHelper = PagerSnapHelper()
        itemView.images_rv.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            this.adapter = adapter
            this.onFlingListener = null
            snapHelper.attachToRecyclerView(this)
            itemView.rv_pi.attachToRecyclerView(this)
        }
        adapter.addItems(items)
    }
}

fun getLikeImage(state: Boolean): Int {
    return if (state) R.drawable.ic_liked
    else R.drawable.ic_unliked
}