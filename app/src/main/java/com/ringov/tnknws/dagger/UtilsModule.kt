package com.ringov.tnknws.dagger

import com.google.gson.Gson
import com.ringov.tnknws.utils.RxSchedulers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
class UtilsModule {

    @Provides
    fun provideRxSchedulers() = RxSchedulers(Schedulers.io(), AndroidSchedulers.mainThread())

    @Provides
    fun provideGson() = Gson()
}