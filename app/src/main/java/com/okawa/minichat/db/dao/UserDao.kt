package com.okawa.minichat.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.okawa.minichat.db.model.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun insert(user: UserEntity)

    @Insert(onConflict = REPLACE)
    fun insertAll(users: List<UserEntity>)

    @Query("SELECT COUNT(*) FROM user")
    fun count() : Int

}