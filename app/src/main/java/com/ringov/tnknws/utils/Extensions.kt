package com.ringov.tnknws.utils

import android.widget.TextView
import androidx.core.text.HtmlCompat

fun TextView.showHtml(string: String) {
    this.text = HtmlCompat.fromHtml(string, HtmlCompat.FROM_HTML_MODE_COMPACT)
}