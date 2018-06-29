package com.okawa.minichat.usecase

import android.arch.lifecycle.LiveData
import com.okawa.minichat.db.relation.FullMessage

interface ConversationUseCase {

    fun retrieveConversation() : LiveData<List<FullMessage>>

}