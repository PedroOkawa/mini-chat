package com.okawa.minichat.utils

import com.okawa.minichat.api.model.Attachment
import com.okawa.minichat.api.model.Message
import com.okawa.minichat.api.model.User
import com.okawa.minichat.db.dao.AttachmentDao
import com.okawa.minichat.db.dao.MessageDao
import com.okawa.minichat.db.dao.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseManager @Inject constructor(
        private val appExecutors: AppExecutors,
        private val attachmentDao: AttachmentDao,
        private val attachmentMapper: AttachmentMapper,
        private val messageDao: MessageDao,
        private val messageMapper: MessageMapper,
        private val userDao: UserDao,
        private val userMapper: UserMapper
) {

    fun storeAttachments(attachments: List<Attachment>) {
        appExecutors.getDiskIO().execute {
            attachmentDao.insertAll(attachmentMapper.convertToDB(attachments))
        }
    }

    fun storeMessages(messages: List<Message>) {
        appExecutors.getDiskIO().execute {
            messageDao.insertAll(messageMapper.convertToDB(messages))
        }
    }

    fun storeUsers(users: List<User>) {
        appExecutors.getDiskIO().execute {
            userDao.insertAll(userMapper.convertToDB(users))
        }
    }

    fun retrieveAttachments() = attachmentDao.selectAll()

    fun retrieveMessages() = messageDao.selectAll()

    fun retrieveUsers() = userDao.selectAll()

}