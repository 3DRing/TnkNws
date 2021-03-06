package com.ringov.tnknws.dagger

import com.ringov.tnknws.ui.content.SingleNewsFragment
import com.ringov.tnknws.ui.feed.FeedFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, DomainModule::class, UtilsModule::class])
interface AppComponent {
    fun inject(feedFragment: FeedFragment)
    fun inject(feedFragmentSingle: SingleNewsFragment)
}