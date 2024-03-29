package org.example.client_service.storage.interfaces.user

import org.example.client_service.domain.User

interface UserRepositoryInterface {

    fun get(): List<User>

    fun create(name: String, surname: String, email: String, birthdate: String): User
//
//    fun update(): User
//
//    fun delete(): Boolean

}