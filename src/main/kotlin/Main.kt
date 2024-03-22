package org.example

import io.javalin.Javalin
import org.example.DB.ConnectionInterface
import org.example.config.Connection
import org.example.router.user.UserRouter

fun main() {

    val app = Javalin.create().start(7070)

    val userRouter = UserRouter()

    userRouter.get(app)


    //teste de conexão. remover
    app.get("/connection") { ctx ->

       try {

           val conn: ConnectionInterface = Connection()

           conn.connect().use {connection ->

               ctx.json(println("Conexão com o banco de dados estabelecida com sucesso! . ${conn}", ))

           }

       } catch (e: Exception) {

           ctx.status(500).result("Erro ao conectar ao banco de dados: ${e.message}")

       }

    }



}