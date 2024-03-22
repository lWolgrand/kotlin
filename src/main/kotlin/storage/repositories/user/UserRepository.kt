package org.example.storage.repositories.user

import org.example.DB.ConnectionInterface
import org.example.config.Connection
import org.example.domain.User
import org.example.storage.interfaces.user.UserRepositoryInterface

class UserRepository: UserRepositoryInterface {

    private val conn: ConnectionInterface = Connection()

    override fun get(): List<User> {
        val users = mutableListOf<User>()

        conn.connect().use { connection ->
            val statement = connection.prepareStatement("SELECT * FROM crud.users")
            val resultSet = statement.executeQuery()

            while (resultSet.next()) {
                val userId = resultSet.getInt("id")
                val userName = resultSet.getString("name")
                val user = User(userId, userName)
                users.add(user)
            }
        }

        return users
    }


}