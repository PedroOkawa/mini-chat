package com.okawa.minichat.utils

import com.okawa.minichat.api.model.Message
import com.okawa.minichat.db.model.MessageEntity
import javax.inject.Inject

class MessageMapper @Inject constructor() {

    fun convertToDB(message: Message) = MessageEntity(message.id, message.userId, message.content)

    fun convertToDB(messages: List<Message>) : List<MessageEntity> {
        val result = ArrayList<MessageEntity>()
        messages.forEach { result.add(convertToDB(it)) }
        return result
    }

}