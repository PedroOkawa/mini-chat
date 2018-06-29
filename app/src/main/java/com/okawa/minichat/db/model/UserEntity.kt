package com.okawa.minichat.db.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(@PrimaryKey @ColumnInfo(name = "_user_id") var id: Long,
                      @ColumnInfo(name = "name") var name: String,
                      @ColumnInfo(name = "avatar_id") var avatarId: String)