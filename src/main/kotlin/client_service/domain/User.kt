package org.example.client_service.domain


data class User(
    val id: String,
    val name: String,
    val surname: String,
    val email: String,
    val birthdate: String,
)
