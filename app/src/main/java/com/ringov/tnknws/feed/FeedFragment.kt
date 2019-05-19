package com.ringov.tnknws.feed

import androidx.recyclerview.widget.LinearLayoutManager
import com.ringov.tnknws.App
import com.ringov.tnknws.Logger
import com.ringov.tnknws.R
import com.ringov.tnknws.RxSchedulers
import com.ringov.tnknws.base.BaseFragment
import com.ringov.tnknws.data.Api
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class FeedFragment : BaseFragment() {

    private lateinit var adapter: FeedAdapter

    @Inject
    lateinit var api: Api
    @Inject
    lateinit var schedulers: RxSchedulers

    lateinit var newsDisposable: Disposable

    override fun inject() {
        App.component.inject(this)
    }

    override fun getLayout() = R.layout.fragment_feed

    override fun initViews() {
        feed_list.layoutManager = LinearLayoutManager(context)
        adapter = FeedAdapter(this::onItemClick)
        feed_list.adapter = adapter

        adapter.update(listOf(FeedItem(0, "One"), FeedItem(1, "Two"), FeedItem(2, "Three")))

        newsDisposable = api.getNews()
            .subscribeOn(schedulers.io)
            .subscribe({
                Logger.d(it.body().toString())
            }) { Logger.e(it) }
    }

    private fun onItemClick(id: Long) {
        Logger.d("Item clicked: $id")
    }
}