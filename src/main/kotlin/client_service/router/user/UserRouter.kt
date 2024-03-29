package org.example.client_service.router.user

import com.google.gson.JsonParser
import io.javalin.Javalin
import org.example.client_service.service.user.UserService
import org.example.client_service.storage.repositories.user.UserRepository
import java.util.logging.Logger

class UserRouter {

    fun get(app: Javalin) {
        app.get("/users") { ctx ->
            val users = UserService().get()
            ctx.json(users).status(200)
        }
    }

    fun create(app: Javalin) {
        app.post("/create") { ctx ->
            val requestBody = ctx.body()
            val jsonObject = JsonParser().parse(requestBody).asJsonObject
            val name = jsonObject.getAsJsonPrimitive("name").asString
            val surname = jsonObject.getAsJsonPrimitive("surname").asString
            val email = jsonObject.getAsJsonPrimitive("email").asString
            val birthdate = jsonObject.getAsJsonPrimitive("birthdate").asString
            val users = UserService().create(name, surname, email, birthdate)
            ctx.json(users).status(200)
            Logger.getLogger(UserRepository::class.java.name).info(" Router - CREATE")
        }
    }
}