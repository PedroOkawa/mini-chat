package com.okawa.minichat.repository

import com.okawa.minichat.api.ApiManager
import com.okawa.minichat.model.api.Conversation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ConversationRepositoryImpl @Inject constructor(private val apiManager: ApiManager) : ConversationRepository {

    override fun getConversation() {
        apiManager.getConversation().enqueue(object: Callback<Conversation> {
            override fun onFailure(call: Call<Conversation>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<Conversation>?, response: Response<Conversation>?) {

            }
        })
    }

}