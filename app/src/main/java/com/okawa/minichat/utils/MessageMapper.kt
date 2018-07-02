package com.okawa.minichat.utils

import com.okawa.minichat.api.model.Attachment
import com.okawa.minichat.api.model.Message
import com.okawa.minichat.db.model.MessageEntity
import javax.inject.Inject

class MessageMapper @Inject constructor() {

    fun convertToDB(message: Message, attachment: Attachment) : MessageEntity {
        return MessageEntity(0,
                message.id,
                message.userId,
                message.content,
                true,
                attachment.id,
                attachment.title,
                attachment.url,
                attachment.thumbnailUrl)
    }

    fun convertToDB(message: Message) : MessageEntity {
        return MessageEntity(0,
                message.id,
                message.userId,
                message.content)
    }

    fun convertToDB(messages: List<Message>) : List<MessageEntity> {
        val result = ArrayList<MessageEntity>()
        messages.forEach { message ->
            result.add(convertToDB(message))
            if(message.attachments != null && message.attachments.isNotEmpty()) {
                message.attachments.forEach { attachment ->
                    result.add(convertToDB(message, attachment))
                }
            }
        }
        return result
    }

}