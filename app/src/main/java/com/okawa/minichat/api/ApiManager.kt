package com.okawa.minichat.api

import javax.inject.Inject

class ApiManager @Inject constructor(private  val apiService: ApiService) {

    public fun getConversation() = apiService.getConversation()

}