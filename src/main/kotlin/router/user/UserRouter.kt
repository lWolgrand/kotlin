package org.example.router.user

import io.javalin.Javalin
import io.javalin.http.Handler
import org.example.service.user.UserService

class UserRouter {

    private val service = UserService()

    fun get(app: Javalin) {
        app.get("/users", Handler { ctx ->
            val users = service.get()
                ctx.json(users).status(200)
        })
    }
}