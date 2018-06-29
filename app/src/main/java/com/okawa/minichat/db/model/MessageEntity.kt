package com.okawa.minichat.db.model

import android.arch.persistence.room.*

@Entity(tableName = "message")
data class MessageEntity(@PrimaryKey @ColumnInfo(name = "_message_id") var id: Long,
                         @ColumnInfo(name = "user_id") var userId: Long,
                         @ColumnInfo(name = "content") var content: String)