package com.ringov.tnknws.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    companion object {
        const val BASE_URL = "https://api.tinkoff.ru/v1/"
    }

    @GET("news")
    fun getNews(): Single<Response<CommonResponse<List<FeedItemRaw>>>>

    @GET("news_content")
    fun getNewsContent(): Single<Response<Map<String, *>>>
}