package com.okawa.minichat.utils

import com.okawa.minichat.api.model.Attachment
import com.okawa.minichat.db.model.AttachmentEntity
import javax.inject.Inject

class AttachmentMapper @Inject constructor() {

    fun convertToDB(attachment: Attachment) = AttachmentEntity(attachment.id, attachment.title, attachment.url, attachment.thumbnailUrl)

    fun convertToDB(attachments: List<Attachment>) : List<AttachmentEntity> {
        val result = ArrayList<AttachmentEntity>()
        attachments.forEach { result.add(convertToDB(it)) }
        return result
    }

}