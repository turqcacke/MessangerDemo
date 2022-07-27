package com.demo.messanger.domain.repository

import com.demo.messanger.domain.entity.Message

interface MessageRepository {
    suspend fun getMessages(): List<Message>
    suspend fun send(): Boolean
}