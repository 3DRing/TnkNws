package com.ringov.tnknws.ui.content

import androidx.recyclerview.widget.LinearLayoutManager
import com.ringov.tnknws.App
import com.ringov.tnknws.R
import com.ringov.tnknws.data.NewsRepo
import com.ringov.tnknws.domain.GetNewsContentUsecase
import com.ringov.tnknws.ui.base.BaseFragment
import com.ringov.tnknws.utils.Logger
import com.ringov.tnknws.utils.RxSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_feed.*
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

    override fun getLayout() = R.layout.fragment_feed

    override fun initViews() {
        feed_list.layoutManager = LinearLayoutManager(context)

        val id = newsRepo.currentNews()
        if (id >= 0) {
            contentDisposable = getNewsContentUsecase.execute(id)
                .observeOn(schedulers.mainThread)
                .subscribe({
                    Logger.d(it.toString())
                }) { Logger.e(it) }
        } else {
            Logger.w("WARNING: Single news screen has been opened with invalid id = $id")
        }
    }
}