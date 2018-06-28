package com.okawa.minichat.api.service

import com.okawa.minichat.api.model.Conversation
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("conversation")
    fun getConversation() : Call<Conversation>

}