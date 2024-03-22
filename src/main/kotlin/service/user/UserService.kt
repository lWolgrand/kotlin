package org.example.service.user

import org.example.domain.User
import org.example.storage.repositories.user.UserRepository

class UserService {

    private val repository = UserRepository()

    fun get(): List<User> {
        return repository.get()
    }
}