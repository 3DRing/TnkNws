package com.ringov.tnknws.feed

import androidx.recyclerview.widget.LinearLayoutManager
import com.ringov.tnknws.Logger
import com.ringov.tnknws.R
import com.ringov.tnknws.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : BaseFragment() {

    private lateinit var adapter: FeedAdapter

    override fun getLayout() = R.layout.fragment_feed

    override fun initViews() {
        feed_list.layoutManager = LinearLayoutManager(context)
        adapter = FeedAdapter(this::onItemClick)
        feed_list.adapter = adapter

        adapter.update(listOf(FeedItem(0, "One"), FeedItem(1, "Two"), FeedItem(2, "Three")))
    }

    private fun onItemClick(id: Long) {
        Logger.d("Item clicked: $id")
    }
}