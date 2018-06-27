package com.okawa.minichat.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("conversation")
    fun getConversation() : Call<Void>

}