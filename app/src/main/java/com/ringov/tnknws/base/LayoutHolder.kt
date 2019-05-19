package com.ringov.tnknws.base

import androidx.annotation.LayoutRes

interface LayoutHolder {
    @LayoutRes
    fun getLayout(): Int
}