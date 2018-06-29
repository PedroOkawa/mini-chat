package com.okawa.minichat.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.okawa.minichat.db.MiniChatDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    companion object {
        private const val DATABASE_NAME = "mini_chat.db"
    }

    @Singleton
    @Provides
    fun provideDatabase(app: Application) : MiniChatDatabase {
        return Room
                .databaseBuilder(app, MiniChatDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideAttachmentDao(database: MiniChatDatabase) = database.getAttachmentDao()

    @Singleton
    @Provides
    fun provideFullMessageDao(database: MiniChatDatabase) = database.getFullMessageDao()

    @Singleton
    @Provides
    fun provideMessageDao(database: MiniChatDatabase) = database.getMessageDao()

    @Singleton
    @Provides
    fun provideUserDao(database: MiniChatDatabase) = database.getUserDao()

}