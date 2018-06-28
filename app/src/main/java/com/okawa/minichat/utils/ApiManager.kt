package com.okawa.minichat.utils

import com.okawa.minichat.api.service.ApiService
import javax.inject.Inject

class ApiManager @Inject constructor(private  val apiService: ApiService) {

    fun getConversation() = apiService.getConversation()

}