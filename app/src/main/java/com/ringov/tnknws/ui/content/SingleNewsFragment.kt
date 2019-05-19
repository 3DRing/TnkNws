package com.ringov.tnknws.ui.content

import com.ringov.tnknws.App
import com.ringov.tnknws.R
import com.ringov.tnknws.data.NewsRepo
import com.ringov.tnknws.domain.GetNewsContentUsecase
import com.ringov.tnknws.ui.base.BaseFragment
import com.ringov.tnknws.utils.Logger
import com.ringov.tnknws.utils.RxSchedulers
import com.ringov.tnknws.utils.showHtml
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_single_news.*
import javax.inject.Inject


class SingleNewsFragment : BaseFragment() {

    @Inject
    lateinit var newsRepo: NewsRepo
    @Inject
    lateinit var getNewsContentUsecase: GetNewsContentUsecase
    @Inject
    lateinit var schedulers: RxSchedulers

    lateinit var contentDisposable: Disposable

    override fun inject() {
        App.component.inject(this)
    }

    override fun getLayout() = R.layout.fragment_single_news

    override fun initViews() {
        val id = newsRepo.currentNews()
        if (id >= 0) {
            contentDisposable = getNewsContentUsecase.execute(id)
                .observeOn(schedulers.mainThread)
                .subscribe(this::showNews) { Logger.e(it) }
        } else {
            Logger.w("WARNING: Single news screen has been opened with invalid id = $id")
        }
    }

    private fun showNews(news: NewsContent) {
        Logger.d(news.toString())
        news_content.showHtml(news.text)
    }
}