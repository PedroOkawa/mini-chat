package com.okawa.minichat.utils

import com.okawa.minichat.api.model.Conversation
import com.okawa.minichat.api.model.Message
import com.okawa.minichat.api.model.User
import com.okawa.minichat.db.dao.FullMessageDao
import com.okawa.minichat.db.dao.MessageDao
import com.okawa.minichat.db.dao.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseManager @Inject constructor(
        private val fullMessageDao: FullMessageDao,
        private val messageDao: MessageDao,
        private val messageMapper: MessageMapper,
        private val userDao: UserDao,
        private val userMapper: UserMapper
) {

    fun storeConversation(conversation: Conversation) {
        storeMessages(conversation.messages)
        storeUsers(conversation.users)
    }

    private fun storeMessages(messages: List<Message>) {
        messageDao.insertAll(messageMapper.convertToDB(messages))
    }

    private fun storeUsers(users: List<User>) {
        userDao.insertAll(userMapper.convertToDB(users))
    }

    fun retrieveConversation() = fullMessageDao.loadFullMessages()

    fun deleteMessage(messageId: Long) {
        messageDao.delete(messageId)
    }

}