package com.okawa.minichat.db.model

import android.arch.persistence.room.*

@Entity(tableName = "message")
data class MessageEntity(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long = 0,
                         @ColumnInfo(name = "message_id") var messageId: Long,
                         @ColumnInfo(name = "user_id") var userId: Long,
                         @ColumnInfo(name = "content") var content: String,
                         @ColumnInfo(name = "is_attachment") var isAttachment: Boolean = false,
                         @ColumnInfo(name = "attachment_id") var attachmentId: String = "",
                         @ColumnInfo(name = "attachment_title") var title: String = "",
                         @ColumnInfo(name = "attachment_url") var url: String = "",
                         @ColumnInfo(name = "attachment_thumbnail_url") var thumbnailUrl: String = "")