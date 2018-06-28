package com.okawa.minichat.db.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(@PrimaryKey val id: Long,
                      @ColumnInfo(name = "name") val name: String,
                      @ColumnInfo(name = "avatar_id") val avatarId: String)