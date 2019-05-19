package com.ringov.tnknws.data

import com.google.gson.annotations.SerializedName

data class NewsContentRaw(
    @SerializedName("id")
    var id: Long = 0,
    @SerializedName("title")
    var title: FeedItemRaw? = null,
    @SerializedName("content")
    var text: String = ""
)