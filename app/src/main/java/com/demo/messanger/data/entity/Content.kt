package com.demo.messanger.data.entity

sealed class Content {
    data class TextContent(val text: String): Content()
    data class VideoContent(val text: String? = null, val videoLink: String): Content()
}