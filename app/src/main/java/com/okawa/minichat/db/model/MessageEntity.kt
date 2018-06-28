package com.okawa.minichat.db.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "message")
data class MessageEntity(@PrimaryKey val id: Long,
                         @ColumnInfo(name = "user_id") val userId: Long,
                         @ColumnInfo(name = "content") val content: String)