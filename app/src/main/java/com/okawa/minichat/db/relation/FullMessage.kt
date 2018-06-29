package com.okawa.minichat.db.relation

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.okawa.minichat.db.model.AttachmentEntity
import com.okawa.minichat.db.model.MessageEntity
import com.okawa.minichat.db.model.UserEntity

data class FullMessage(
        @Embedded
        var message: MessageEntity?,
        @Embedded
        var user: UserEntity?,
        @Relation(parentColumn = "_message_id", entityColumn = "message_id", entity = AttachmentEntity::class)
        var attachments: List<AttachmentEntity>?
) {

        constructor() : this(null, null, null)

}