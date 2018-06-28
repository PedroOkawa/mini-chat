package com.okawa.minichat.model.api

data class Message(val id: Long, val userId: Long, val content: String) {

    var attachments: Attachments? = null

}