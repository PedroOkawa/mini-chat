package com.okawa.minichat.api.service

import android.arch.lifecycle.LiveData
import com.okawa.minichat.api.model.Conversation
import com.okawa.minichat.api.response.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("conversation")
    fun getConversation() : LiveData<ApiResponse<Conversation>>

}