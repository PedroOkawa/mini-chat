package com.okawa.minichat.db.model

import android.arch.persistence.room.*

@Entity(tableName = "attachment")
data class AttachmentEntity(@PrimaryKey @ColumnInfo(name = "_attachment_id") var id: String,
                            @ColumnInfo(name = "message_id") var messageId: Long,
                            @ColumnInfo(name = "title") var title: String,
                            @ColumnInfo(name = "url") var url: String,
                            @ColumnInfo(name = "thumbnail_url") var thumbnailUrl: String)