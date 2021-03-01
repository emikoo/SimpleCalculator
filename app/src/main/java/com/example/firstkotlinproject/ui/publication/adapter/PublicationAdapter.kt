package com.example.firstkotlinproject.ui.publication.adapter

import CommentsPublicationAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsthomework.R
import com.example.firstkotlinproject.data.models.Comment
import com.example.firstkotlinproject.data.models.Images
import com.example.firstkotlinproject.data.models.Publication
import com.example.firstkotlinproject.ui.image_list.adapter.ImagePublicationAdapter
import kotlinx.android.synthetic.main.item_main.view.*

class PublicationAdapter(private val listener: ClickListener) : RecyclerView.Adapter<BaseViewHolder>() {

    private var items = mutableListOf<Publication>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return if (viewType == VIEW_TYPE_DATE) PublicationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        ) else EmptyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_empty, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return if (items.count() == 0) 1
        else items.count()
    }

    override fun getItemViewType(position: Int): Int {
        return if (items.count() == 0) VIEW_TYPE_EMPTY
        else VIEW_TYPE_DATE
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val type = getItemViewType(position)
        if (type == VIEW_TYPE_DATE) setupPublicationRecyclerView(holder as PublicationViewHolder, position)
    }

    private fun setupPublicationRecyclerView(holder: PublicationViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
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

    companion object {
        private const val VIEW_TYPE_DATE = 0
        private const val VIEW_TYPE_EMPTY = 1
    }
}

open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class PublicationViewHolder(itemView: View) : BaseViewHolder(itemView) {
    fun bind(item: Publication) {
        Glide.with(itemView.context).load(item.image).into(itemView.icon_civ)
        itemView.name_tv.text = item.name
        itemView.like_number_pub.text = "${item.countOfLikes}"
        if (item.countOfLikes != 0) itemView.like_number_pub.visibility = View.VISIBLE
        else itemView.like_number_pub.visibility = View.GONE
        itemView.like_btn.setImageResource(getLikeImage(item.isFavorite))
        setupImagesRecyclerView(item.images)
        setupCommentsRecyclerView(item.comment, itemView.comments_rv)
    }

    //protected - метод с параметром доступа виден для других классов только внутри родительской папки
    //private - метод с параметром доступа виден для других классов только внутри класс
    //public - метод с параметром доступа виден всем
    //internal - метод с параметром доступа виден для других только для родительского модуля

    private fun setupCommentsRecyclerView(items: MutableList<Comment>?, recyclerView: RecyclerView) {
        val adapter = CommentsPublicationAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(recyclerView.context)
            this.adapter = adapter
        }
        items?.let { adapter.addItems(it) }
    }

    private fun setupImagesRecyclerView(items: MutableList<Images>?) {
        val adapter = ImagePublicationAdapter()
        val snapHelper = PagerSnapHelper()
        itemView.images_rv.apply {
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            this.adapter = adapter
            this.onFlingListener = null
            snapHelper.attachToRecyclerView(this)
            itemView.rv_pi.attachToRecyclerView(this)
        }
        items?.let { adapter.addItems(it) }
    }
}

class EmptyViewHolder(itemView: View) : BaseViewHolder(itemView) {
    fun bind(item: Publication) {
    }
}

fun getLikeImage(state: Boolean): Int {
    return if (state) R.drawable.ic_liked
    else R.drawable.ic_unliked
}