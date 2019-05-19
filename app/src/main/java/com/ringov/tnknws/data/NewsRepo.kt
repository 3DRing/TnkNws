package com.ringov.tnknws.data

class NewsRepo(private var currentId: Long = -1) {

    fun update(id: Long) {
        currentId = id
    }

    fun currentNews(): Long = currentId

}