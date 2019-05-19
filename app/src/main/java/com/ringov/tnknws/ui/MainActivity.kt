package com.ringov.tnknws.ui

import android.os.Bundle
import com.ringov.tnknws.R
import com.ringov.tnknws.ui.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun containerLayoutId() = R.id.container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openScreen(Screen.Feed)
    }
}
