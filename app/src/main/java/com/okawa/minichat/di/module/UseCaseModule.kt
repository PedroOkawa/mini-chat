package com.okawa.minichat.di.module

import com.okawa.minichat.usecase.ConversationUseCase
import com.okawa.minichat.usecase.ConversationUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindConversationUseCase(conversationUseCaseImpl: ConversationUseCaseImpl) : ConversationUseCase

}