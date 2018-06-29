package com.okawa.minichat.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.okawa.minichat.db.model.AttachmentEntity

@Dao
interface AttachmentDao {

    @Insert(onConflict = REPLACE)
    fun insert(attachment: AttachmentEntity)

    @Insert(onConflict = REPLACE)
    fun insertAll(attachments: List<AttachmentEntity>)

    @Query("SELECT COUNT(*) FROM attachment")
    fun count() : Int

}