package com.ringov.tnknws.ui.feed

import androidx.recyclerview.widget.LinearLayoutManager
import com.ringov.tnknws.App
import com.ringov.tnknws.R
import com.ringov.tnknws.domain.FeedUsecase
import com.ringov.tnknws.ui.base.BaseFragment
import com.ringov.tnknws.utils.Logger
import com.ringov.tnknws.utils.RxSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class FeedFragment : BaseFragment() {

    private lateinit var adapter: FeedAdapter

    @Inject
    lateinit var feedUsecase: FeedUsecase
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

        newsDisposable = feedUsecase.execute()
            .observeOn(schedulers.mainThread)
            .subscribe(adapter::update) { Logger.e(it) }
    }

    private fun onItemClick(id: Long) {
        Logger.d("Item clicked: $id")
    }
}