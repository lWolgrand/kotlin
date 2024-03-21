package org.example

import io.javalin.Javalin
import org.example.DB.ConnectionInterface
import org.example.config.Connection
fun main() {

    val app = Javalin.create().start(7070)

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

    app.get("/usuarios") { ctx ->

        try {

            val conn: ConnectionInterface = Connection()

            conn.connect().use { connection ->

                val statement = connection.createStatement()

                val resultSet = statement.executeQuery("SELECT * FROM users")

                val users = mutableListOf<String>()

                while (resultSet.next()) {

                    val userId = resultSet.getInt("id")

                    val name = resultSet.getString("name")

                    users.add("id: $userId, Name: $name")
                }
                ctx.json(users)
            }

        } catch (e: Exception) {

            ctx.status(500).result("Message:  ${e.message}")

        }

    }

}