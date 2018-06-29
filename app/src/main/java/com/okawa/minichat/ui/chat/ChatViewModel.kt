package com.okawa.minichat.ui.chat

import android.arch.lifecycle.ViewModel
import com.okawa.minichat.repository.ConversationRepository
import javax.inject.Inject

class ChatViewModel @Inject constructor(private val conversationRepository: ConversationRepository): ViewModel() {

    fun retrieveConversation() = conversationRepository.getConversation()

}
