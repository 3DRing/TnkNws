package com.ringov.tnknws.ui.feed

import androidx.recyclerview.widget.DiffUtil


class FeedDiffCallback :
    DiffUtil.ItemCallback<FeedItem>() {
    override fun areItemsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean = oldItem == newItem
}