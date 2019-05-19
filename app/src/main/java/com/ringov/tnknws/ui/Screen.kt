package com.ringov.tnknws.ui

import com.ringov.tnknws.ui.base.BaseFragment
import com.ringov.tnknws.ui.content.SingleNewsFragment
import com.ringov.tnknws.ui.feed.FeedFragment

enum class Screen(val create: () -> BaseFragment) {
    Feed({ FeedFragment() }), SingleNews({ SingleNewsFragment() })
}