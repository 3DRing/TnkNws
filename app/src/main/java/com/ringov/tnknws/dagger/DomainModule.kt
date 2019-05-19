package com.ringov.tnknws.dagger

import com.ringov.tnknws.data.Api
import com.ringov.tnknws.domain.FeedUsecase
import com.ringov.tnknws.domain.GetNewsContentUsecase
import com.ringov.tnknws.utils.RxSchedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    fun provideFeedUsecase(schedulers: RxSchedulers, api: Api) = FeedUsecase(schedulers, api)

    @Provides
    fun provideGetNewsContentUsecase(schedulers: RxSchedulers, api: Api) = GetNewsContentUsecase(schedulers, api)
}