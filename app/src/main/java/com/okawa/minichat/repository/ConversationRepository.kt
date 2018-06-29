package com.okawa.minichat.repository

import android.arch.lifecycle.LiveData
import com.okawa.minichat.db.relation.FullMessage

interface ConversationRepository {

    fun getConversation() : LiveData<List<FullMessage>>

}