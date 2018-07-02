package com.okawa.minichat.db.relation

import android.arch.persistence.room.Embedded
import com.okawa.minichat.db.model.MessageEntity
import com.okawa.minichat.db.model.UserEntity

data class FullMessageEntity(

        @Embedded
        var message: MessageEntity?,
        @Embedded
        var user: UserEntity?
) {

        constructor() : this(null, null)

}