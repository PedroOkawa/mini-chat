package com.okawa.minichat.di.module

import com.okawa.minichat.repository.ConversationRepository
import com.okawa.minichat.repository.ConversationRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindConversationRepository(conversationRepositoryImpl: ConversationRepositoryImpl) : ConversationRepository

}