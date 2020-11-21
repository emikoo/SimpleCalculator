package com.example.firsthomework.ui.city

import android.net.sip.SipSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firsthomework.ui.City
import com.example.firsthomework.R

class MainAdapter(private var listener: Listener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var array = mutableListOf<City>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.name
        holder.description.text = item.description
        holder.itemView.setOnClickListener{
            listener.onItemClick(item)
        }
    }

    fun updateItems(items: MutableList<City>) {
        array = items
        notifyDataSetChanged()
    }

    fun addItem(value: City) {
        array.add(value)
        notifyItemInserted(array.lastIndex)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.item_image)
        var name: TextView = itemView.findViewById(R.id.item_name)
        var description: TextView = itemView.findViewById(R.id.item_description)
    }

    interface Listener{
        fun onItemClick(item: City)
    }
}