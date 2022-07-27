package com.demo.messanger.di

import com.demo.messanger.data.datasource.MessageListDataSource
import com.demo.messanger.data.repository.MessageRepositoryImpl
import com.demo.messanger.domain.entity.Message
import com.demo.messanger.domain.repository.MessageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMessageRepository(
        messageListDataSource: MessageListDataSource
    ): MessageRepository{
        return MessageRepositoryImpl(messageListDataSource)
    }
}