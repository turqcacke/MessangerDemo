package com.demo.messanger.data.mappers.base

interface ListDto2Domain<Source, Product>{
    fun convertList(src: List<Source>): List<Product>
}