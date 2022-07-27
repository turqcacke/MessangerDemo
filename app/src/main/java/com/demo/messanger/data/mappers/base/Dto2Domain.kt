package com.demo.messanger.data.mappers.base

interface Dto2Domain <Source, Product> {
    fun convert(src: Source): Product
}
