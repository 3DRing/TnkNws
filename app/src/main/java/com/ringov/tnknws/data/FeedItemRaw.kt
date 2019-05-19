package com.ringov.tnknws.data

import com.google.gson.annotations.SerializedName

data class FeedItemRaw(
    @SerializedName("id")
    var id: Long = 0,
    @SerializedName("text")
    var title: String = ""
)