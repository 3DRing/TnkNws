package com.ringov.tnknws

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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
