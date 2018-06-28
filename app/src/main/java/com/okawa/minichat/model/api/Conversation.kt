package com.okawa.minichat.model.api

data class Conversation(val messages: List<Message>, val users: List<User>)