package com.okawa.minichat.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.okawa.minichat.db.relation.FullMessage

@Dao
interface FullMessageDao {

    @Query("SELECT message.*, user.* FROM message INNER JOIN user ON message.user_id = user._user_id")
    fun loadFullMessages() : LiveData<List<FullMessage>>

    @Query("SELECT EXISTS(SELECT 1 FROM message)")
    fun hasAnyRecord() : Boolean

}