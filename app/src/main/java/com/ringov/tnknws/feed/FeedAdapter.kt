package com.ringov.tnknws.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ringov.tnknws.R

class FeedAdapter(private val clickCallback: (Long) -> Unit) :
    ListAdapter<FeedItem, FeedAdapter.ViewHolder>(FeedDiffCallback()) {

    fun update(rates: List<FeedItem>) {
        submitList(rates)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.feed_item_layout, parent, false)
        return ViewHolder(v, clickCallback)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    class ViewHolder(itemView: View, private val clickCallback: (Long) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.title)

        fun bind(item: FeedItem) {
            itemView.setOnClickListener { clickCallback(item.id) }
            title.text = item.title
        }
    }
}