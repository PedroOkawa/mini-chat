package com.okawa.minichat.utils

import com.okawa.minichat.api.service.ApiService
import javax.inject.Inject

open class ApiManager @Inject constructor(private  val apiService: ApiService) {

    open fun getConversation() = apiService.getConversation()

}