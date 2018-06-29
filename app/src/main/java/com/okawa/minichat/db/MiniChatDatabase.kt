package com.okawa.minichat.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.okawa.minichat.db.dao.AttachmentDao
import com.okawa.minichat.db.dao.FullMessageDao
import com.okawa.minichat.db.dao.MessageDao
import com.okawa.minichat.db.dao.UserDao
import com.okawa.minichat.db.model.AttachmentEntity
import com.okawa.minichat.db.model.MessageEntity
import com.okawa.minichat.db.model.UserEntity

@Database(entities = [ AttachmentEntity::class, MessageEntity::class, UserEntity::class ], version = 1)
abstract class MiniChatDatabase : RoomDatabase() {

    abstract fun getAttachmentDao() : AttachmentDao

    abstract fun getFullMessageDao() : FullMessageDao

    abstract fun getMessageDao() : MessageDao

    abstract fun getUserDao() : UserDao

}