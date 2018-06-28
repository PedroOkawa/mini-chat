package com.okawa.minichat.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("conversation")
    fun getConversation() : Response<Void>

}