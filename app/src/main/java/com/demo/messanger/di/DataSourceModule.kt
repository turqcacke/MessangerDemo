package com.demo.messanger.di

import com.demo.messanger.data.datasource.MessageListDataSource
import com.demo.messanger.data.datasource.MessageListMockDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideMessageListDataSource(): MessageListDataSource = MessageListMockDataSource()
}