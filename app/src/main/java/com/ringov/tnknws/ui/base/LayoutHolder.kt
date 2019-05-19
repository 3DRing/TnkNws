package com.ringov.tnknws.ui.base

import androidx.annotation.LayoutRes

interface LayoutHolder {
    @LayoutRes
    fun getLayout(): Int
}