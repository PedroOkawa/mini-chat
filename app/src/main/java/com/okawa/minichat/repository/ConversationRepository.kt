package com.okawa.minichat.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.okawa.minichat.data.Result
import com.okawa.minichat.db.relation.FullMessage

interface ConversationRepository {

    fun getConversation() : LiveData<Result<PagedList<FullMessage>>>

    fun deleteMessage(messageId: Long)

}