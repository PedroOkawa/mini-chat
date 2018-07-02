package com.okawa.minichat.ui.confirmation

import android.arch.lifecycle.ViewModel
import com.okawa.minichat.repository.ConversationRepository
import javax.inject.Inject

class ConfirmationViewModel @Inject constructor(private val conversationRepository: ConversationRepository) : ViewModel() {

    fun deleteMessage(messageId: Long?) {
        conversationRepository.deleteMessage(messageId?:return)
    }

}