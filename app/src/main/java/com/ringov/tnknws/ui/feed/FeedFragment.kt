package com.ringov.tnknws.ui.feed

import androidx.recyclerview.widget.LinearLayoutManager
import com.ringov.tnknws.App
import com.ringov.tnknws.R
import com.ringov.tnknws.data.NewsRepo
import com.ringov.tnknws.domain.FeedUsecase
import com.ringov.tnknws.ui.Screen
import com.ringov.tnknws.ui.base.BaseFragment
import com.ringov.tnknws.utils.Logger
import com.ringov.tnknws.utils.RxSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import kotlinx.android.synthetic.main.fragment_feed.*
import javax.inject.Inject

class FeedFragment : BaseFragment() {

    private lateinit var adapter: FeedAdapter

    @Inject
    lateinit var newsRepo: NewsRepo
    @Inject
    lateinit var feedUsecase: FeedUsecase
    @Inject
    lateinit var schedulers: RxSchedulers

    private var newsDisposable: Disposable = Disposables.empty()

    override fun inject() {
        App.component.inject(this)
    }

    override fun getLayout() = R.layout.fragment_feed

    override fun initViews() {
        swipe_layout.setOnRefreshListener(this::updateFeed)
        initList()
        updateFeed()
    }

    private fun initList() {
        feed_list.layoutManager = LinearLayoutManager(context)
        adapter = FeedAdapter(this::onItemClick)
        feed_list.adapter = adapter
    }

    private fun updateFeed() {
        swipe_layout.isRefreshing = false
        newsDisposable.dispose()
        newsDisposable = feedUsecase.execute()
            .observeOn(schedulers.mainThread)
            .subscribe(adapter::update) { Logger.e(it) }
    }

    private fun onItemClick(id: Long) {
        Logger.d("Item clicked: $id")
        newsRepo.update(id)
        openScreen(Screen.SingleNews)
    }
}