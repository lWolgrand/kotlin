package org.example

import io.javalin.Javalin
import org.example.client_service.router.user.UserRouter

fun main() {

    val app = Javalin.create().start(7070)
    UserRouter().get(app)
    UserRouter().create(app)
}