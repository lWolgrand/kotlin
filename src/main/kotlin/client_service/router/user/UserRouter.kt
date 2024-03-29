package org.example.client_service.router.user

import com.google.gson.JsonParser
import io.javalin.Javalin
import org.example.client_service.service.user.UserService
import java.util.logging.Logger

class UserRouter {

    fun get(app: Javalin) {
        app.get("/users") { ctx ->
            val users = UserService().get()
            Logger.getLogger(UserRouter::class.java.name).info(" Router - GET")
            ctx.json(users).status(200)
        }
    }

    fun create(app: Javalin) {
        app.post("/create") { ctx ->
            val jsonObject = JsonParser().parse(ctx.body()).asJsonObject
            Logger.getLogger(UserRouter::class.java.name).info(" Router - CREATE")
            ctx.json(UserService().create(
                jsonObject.getAsJsonPrimitive("name").asString,
                jsonObject.getAsJsonPrimitive("surname").asString,
                jsonObject.getAsJsonPrimitive("email").asString,
                jsonObject.getAsJsonPrimitive("birthdate").asString)).status(200)
        }
    }
}