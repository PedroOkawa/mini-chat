package com.okawa.minichat.utils

import com.okawa.minichat.api.model.User
import com.okawa.minichat.db.model.UserEntity
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun convertToDB(user: User) = UserEntity(user.id, user.name, user.avatarId)

    fun convertToDB(users: List<User>) = users.map { convertToDB(it) }

}