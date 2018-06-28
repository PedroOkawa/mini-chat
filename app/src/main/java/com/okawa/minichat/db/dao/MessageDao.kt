package com.okawa.minichat.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.okawa.minichat.db.model.MessageEntity

@Dao
interface MessageDao {

    @Insert(onConflict = REPLACE)
    fun insert(message: MessageEntity)

    @Insert(onConflict = REPLACE)
    fun insertAll(message: List<MessageEntity>)

    @Query("SELECT * FROM Message")
    fun selectAll() : LiveData<List<MessageEntity>>

}