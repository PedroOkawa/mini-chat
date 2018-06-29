package com.okawa.minichat.usecase

import com.okawa.minichat.repository.ConversationRepository
import javax.inject.Inject

class ConversationUseCaseImpl @Inject constructor(private val conversationRepository: ConversationRepository): ConversationUseCase {

    override fun retrieveConversation() = conversationRepository.getConversation()

}