package com.ringov.tnknws.data

import com.google.gson.annotations.SerializedName

data class CommonResponse<T>(@SerializedName("payload") var payload: T? = null)