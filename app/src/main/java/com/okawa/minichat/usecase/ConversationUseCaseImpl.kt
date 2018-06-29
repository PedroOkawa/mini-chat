package com.okawa.minichat.usecase

import android.arch.lifecycle.LiveData
import android.util.Log
import com.okawa.minichat.db.relation.FullMessage
import com.okawa.minichat.repository.ConversationRepository
import javax.inject.Inject

class ConversationUseCaseImpl @Inject constructor(private val conversationRepository: ConversationRepository): ConversationUseCase {

    override fun retrieveConversation(): LiveData<List<FullMessage>> {
        val result = conversationRepository.getConversation()
        result.observeForever {
            it?.forEach {
                Log.w("TEST", "USER: ${it.user?.name} - MESSAGE: ${it.message?.content} - ATTACHMENT: ${ (!it.attachments?.isEmpty()!!) }");
            }
        }
        return result
    }

}