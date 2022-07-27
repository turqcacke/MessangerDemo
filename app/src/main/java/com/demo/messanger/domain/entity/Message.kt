package com.demo.messanger.domain.entity

import com.demo.messanger.data.entity.Content

data class Message(
    val me: Boolean,
    val content: Content
)