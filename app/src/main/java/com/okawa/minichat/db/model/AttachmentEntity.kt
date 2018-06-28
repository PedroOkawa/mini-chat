package com.okawa.minichat.db.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "attachments")
data class AttachmentEntity(@PrimaryKey val id: String,
                            @ColumnInfo(name = "title") val title: String,
                            @ColumnInfo(name = "url") val url: String,
                            @ColumnInfo(name = "thumbnail_url") val thumbnailUrl: String)