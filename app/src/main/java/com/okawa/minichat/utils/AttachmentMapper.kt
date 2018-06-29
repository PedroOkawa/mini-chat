package com.okawa.minichat.utils

import com.okawa.minichat.api.model.Attachment
import com.okawa.minichat.api.model.Message
import com.okawa.minichat.db.model.AttachmentEntity
import javax.inject.Inject

class AttachmentMapper @Inject constructor() {

    fun convertToDB(messageId: Long, attachment: Attachment) = AttachmentEntity(attachment.id, messageId, attachment.title, attachment.url, attachment.thumbnailUrl)

    fun convertToDB(message: Message) = message.attachments?.map { convertToDB(message.id, it) }

}