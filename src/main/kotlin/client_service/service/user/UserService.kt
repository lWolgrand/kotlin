package org.example.client_service.service.user

import org.example.client_service.domain.User
import org.example.client_service.storage.repositories.user.UserRepository
import java.util.logging.Logger

class UserService {

    fun get(): List<User> {
        return UserRepository().get()
    }

    fun create(name: String, surname: String, email: String, birthdate: String): User {
        Logger.getLogger(UserRepository::class.java.name).info(" Service - CREATE")
        return UserRepository().create(name, surname, email, birthdate)
    }
}