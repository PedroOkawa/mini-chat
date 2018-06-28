package com.okawa.minichat.api.model

data class Conversation(val messages: List<Message>, val users: List<User>)