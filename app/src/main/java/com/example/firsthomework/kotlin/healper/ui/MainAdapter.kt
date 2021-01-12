package com.example.firsthomework.kotlin.healper.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firsthomework.R
import com.example.firsthomework.kotlin.healper.models.Name
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(private var listener: OnItemClick) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var array = mutableListOf<Name>()

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Name) {
            itemView.name_tv.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.count()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = array[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item, position)
        }
    }

    fun update(item: MutableList<Name>) {
        array = item
        notifyDataSetChanged()
    }

    interface OnItemClick{
        fun onItemClick(item: Name, position: Int)
    }
}