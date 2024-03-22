package org.example.domain

import java.util.UUID

data class Car(
    val id: UUID,
    val model: String,
    val ownerId: Int
)