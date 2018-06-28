package com.okawa.minichat.api

import javax.inject.Inject

class ApiManager @Inject constructor(private  val apiService: ApiService) {

    fun getConversation() = apiService.getConversation()

}