package org.example.storage.repositories.user

import org.example.DB.ConnectionInterface
import org.example.config.Connection
import org.example.domain.User
import org.example.storage.interfaces.user.UserRepositoryInterface
import java.sql.SQLException
import java.util.*
import java.util.logging.Logger

class UserRepository: UserRepositoryInterface {

    private val conn: ConnectionInterface = Connection()
    private val logger = Logger.getLogger(UserRepository::class.java.name)

    override fun get(): List<User> {

        val users = mutableListOf<User>()

        try {
            conn.connect().use { connection ->
                val resultSet = connection.prepareStatement("SELECT * FROM crud.users").executeQuery()
                while (resultSet.next()) {
                    users.add(User(
                        id = UUID.nameUUIDFromBytes(resultSet.getBytes("id")),
                        name = resultSet.getString("name")))
                }
            }

        } catch (e: SQLException) {
            e.printStackTrace()
        }

        logger.info(" Repository - GET")

        return users
    }


}