package com.ringov.tnknws.utils

import android.util.Log
import com.ringov.tnknws.BuildConfig

class Logger {
    companion object {
        private const val LOGGER_TAG = "Logger"
        private const val TAGS_SEPARATOR = "|"

        fun d(message: String, vararg tags: String = arrayOf()) {
            if (BuildConfig.DEBUG) {
                log(null, message, tags) { _, m, t -> Log.i(t, m) }
            }
        }

        fun w(message: String, vararg tags: String = arrayOf()) {
            log(null, message, tags) { _, m, t -> Log.w(t, m) }
        }

        fun e(ex: Throwable, vararg tags: String = arrayOf()) {
            log(ex, ex.message ?: "", tags) { e, m, t -> Log.e(t, m, e) }
        }

        private fun log(
            throwable: Throwable? = null,
            message: String,
            tags: Array<out String>,
            logger: (Throwable?, String, String) -> Unit
        ) {
            val allTags = if (tags.isNotEmpty()) {
                val sb = StringBuilder()
                sb.append(LOGGER_TAG).append(TAGS_SEPARATOR)
                tags.forEach { sb.append(it).append(TAGS_SEPARATOR) }
                sb.toString()
            } else {
                LOGGER_TAG
            }
            logger(throwable, message, allTags)
        }
    }
}