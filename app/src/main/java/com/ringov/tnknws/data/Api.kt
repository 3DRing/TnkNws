package com.ringov.tnknws.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    companion object {
        const val BASE_URL = "https://api.tinkoff.ru/v1/"
    }

    @GET("news")
    fun getNewsFeed(): Single<Response<CommonResponse<List<FeedItemRaw>>>>

    @GET("news_content")
    fun getNewsContent(@Query("id") id: Long): Single<Response<CommonResponse<NewsContentRaw>>>
}