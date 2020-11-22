package com.example.firsthomework.ui.news

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firsthomework.R
import com.example.firsthomework.newsArray
import com.example.firsthomework.ui.News
import kotlinx.android.synthetic.main.activity_main.view.*

class NewsAdapter(private var listener: Listener): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var newsArray = mutableListOf<News>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = newsArray[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            listener.onItemClick(item)
        }
    }

    fun updateItem(item: MutableList<News>){
        newsArray = item
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var image: ImageView = itemView.findViewById(R.id.image)
        private var name: TextView = itemView.findViewById(R.id.name)
        private var subtitle: TextView = itemView.findViewById(R.id.subtitle)

        fun bind(item: News){
            image.setImageResource(item.image)
            name.text = item.title
            subtitle.text = item.subtitle
        }
    }

    interface Listener {
        fun onItemClick(item: News)
    }
}