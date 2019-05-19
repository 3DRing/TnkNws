package com.ringov.tnknws.domain

import com.ringov.tnknws.data.Api
import com.ringov.tnknws.data.NewsContentRaw
import com.ringov.tnknws.ui.content.NewsContent
import com.ringov.tnknws.utils.RxSchedulers
import io.reactivex.Single

class GetNewsContentUsecase(private val schedulers: RxSchedulers, private val api: Api) {

    fun execute(id: Long): Single<NewsContent> =
        api.getNewsContent(id)
            .map { it.body() }
            .map { it.payload }
            .map(this::mapItem)
            .subscribeOn(schedulers.io)

    private fun mapItem(item: NewsContentRaw): NewsContent =
        NewsContent(item.id, item.title?.title ?: "", item.text)
}