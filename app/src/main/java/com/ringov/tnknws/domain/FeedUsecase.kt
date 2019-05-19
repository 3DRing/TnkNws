package com.ringov.tnknws.domain

import com.ringov.tnknws.data.Api
import com.ringov.tnknws.data.FeedItemRaw
import com.ringov.tnknws.ui.feed.FeedItem
import com.ringov.tnknws.utils.RxSchedulers
import io.reactivex.Flowable
import io.reactivex.Single

class FeedUsecase(private val schedulers: RxSchedulers, private val api: Api) {
    fun execute(): Single<List<FeedItem>> =
        api.getNewsFeed()
            .map { it.body() }
            .map { it.payload }
            .flatMapPublisher { Flowable.fromIterable(it) }
            .map(this::mapItem)
            .toList()
            .subscribeOn(schedulers.io)

    private fun mapItem(item: FeedItemRaw): FeedItem = FeedItem(item.id, item.title)
}