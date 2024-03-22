package org.example.storage.interfaces.user

import org.example.domain.User

interface UserRepositoryInterface {

    fun get(): List<User>

//    fun create(): User
//
//    fun update(): User
//
//    fun delete(): Boolean

}