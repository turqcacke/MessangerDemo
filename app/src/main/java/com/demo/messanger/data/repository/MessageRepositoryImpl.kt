package com.demo.messanger.data.repository

import com.demo.messanger.data.datasource.MessageListDataSource
import com.demo.messanger.data.mappers.MessageMapper
import com.demo.messanger.domain.entity.Message
import com.demo.messanger.domain.repository.MessageRepository
import java.lang.Thread.sleep

class MessageRepositoryImpl(
    private val messageListDataSource: MessageListDataSource
): MessageRepository{
    override suspend fun getMessages(): List<Message> {
        val mapper = MessageMapper()
        sleep(2000)
        return mapper.convertList(messageListDataSource.getMessageList())
    }

    override suspend fun send(): Boolean {
        sleep(2000)
        return true
    }
}