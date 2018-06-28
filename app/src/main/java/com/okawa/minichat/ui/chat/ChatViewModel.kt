package com.okawa.minichat.ui.chat

import android.arch.lifecycle.ViewModel
import com.okawa.minichat.usecase.ConversationUseCase
import javax.inject.Inject

class ChatViewModel @Inject constructor(private val conversationUseCase: ConversationUseCase): ViewModel() {

    fun retrieveConversation() {
        conversationUseCase.retrieveConversation()
    }

}
