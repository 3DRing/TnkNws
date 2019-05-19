package com.ringov.tnknws.dagger

import com.ringov.tnknws.data.Api
import com.ringov.tnknws.domain.FeedUsecase
import com.ringov.tnknws.utils.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideFeedUsecase(schedulers: RxSchedulers, api: Api) = FeedUsecase(schedulers, api)
}