package com.demo.messanger.data.datasource

import com.demo.messanger.data.entity.MessageDto

interface MessageListDataSource {
    fun getMessageList(): List<MessageDto>
}