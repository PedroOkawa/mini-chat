package com.okawa.minichat.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.okawa.minichat.db.model.AttachmentEntity

@Dao
interface AttachmentDao {

    @Insert(onConflict = REPLACE)
    fun insert(attachment: AttachmentEntity)

    @Insert(onConflict = REPLACE)
    fun insertAll(attachments: List<AttachmentEntity>)

}