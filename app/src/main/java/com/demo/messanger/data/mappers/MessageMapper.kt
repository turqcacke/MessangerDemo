package com.demo.messanger.data.mappers

import com.demo.messanger.data.entity.MessageDto
import com.demo.messanger.data.mappers.base.Dto2Domain
import com.demo.messanger.data.mappers.base.ListDto2Domain
import com.demo.messanger.domain.entity.Message

class MessageMapper: ListDto2Domain<MessageDto, Message>, Dto2Domain<MessageDto, Message> {
    override fun convert(src: MessageDto): Message {
        return Message(
            src.me,
            src.content
        )
    }

    override fun convertList(src: List<MessageDto>): List<Message> {
        val tempList = mutableListOf<Message>()
        for(message in src) tempList.add(convert(message))
        return tempList
    }
}