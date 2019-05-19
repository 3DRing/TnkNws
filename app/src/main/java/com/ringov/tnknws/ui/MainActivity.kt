package com.ringov.tnknws.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ringov.tnknws.R
import com.ringov.tnknws.ui.feed.FeedFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFeedFragment()
    }

    private fun openFeedFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FeedFragment(), FeedFragment::class.java.name).commit()
    }
}
