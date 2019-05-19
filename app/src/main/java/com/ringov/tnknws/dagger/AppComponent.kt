package com.ringov.tnknws.dagger

import com.ringov.tnknws.ui.feed.FeedFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, UtilsModule::class])
interface AppComponent {
    fun inject(feedFragment: FeedFragment)
}