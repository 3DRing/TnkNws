package com.ringov.tnknws.dagger

import com.google.gson.Gson
import com.ringov.tnknws.data.Api
import com.ringov.tnknws.data.NewsRepo
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideNewsRepo() = NewsRepo()

    @Provides
    fun provideClient() = OkHttpClient()

    @Provides
    fun provideRxJavaAdapter(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideGsonConverter(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    fun provideApiRetrofit(
        client: OkHttpClient,
        rxJavaAdapter: RxJava2CallAdapterFactory,
        gsonConverter: GsonConverterFactory
    ): Retrofit = Retrofit.Builder().baseUrl(Api.BASE_URL)
        .addCallAdapterFactory(rxJavaAdapter)
        .addConverterFactory(gsonConverter)
        .client(client).build()

    @Provides
    fun provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
}