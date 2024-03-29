package org.example.client_service.storage.repositories.user

import org.example.DB.ConnectionInterface
import org.example.client_service.domain.User
import org.example.client_service.storage.interfaces.user.UserRepositoryInterface
import org.example.config.Connection
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.logging.Logger
import java.util.UUID

class UserRepository: UserRepositoryInterface {

    private val conn: ConnectionInterface = Connection()

    override fun get(): List<User> {

        val users = mutableListOf<User>()

        try {
            conn.connect().use { connection ->
                val resultSet = connection.prepareStatement("SELECT * FROM crud.users").executeQuery()
                while (resultSet.next()) {
                    users.add(
                        User(
                        id = resultSet.getString("id"),
                        name = resultSet.getString("name"),
                        surname = resultSet.getString("surname"),
                        email = resultSet.getString("email"),
                        birthdate = SimpleDateFormat("dd/MM/yyyy").format(resultSet.getDate("birthdate")),
                    )
                )}
            }

        } catch (e: SQLException) {
            e.printStackTrace()
        }

        Logger.getLogger(UserRepository::class.java.name).info(" Repository - GET")
        return users
    }

    override fun create(name: String, surname: String, email: String, birthdate: String): User {
        val sql = "INSERT INTO crud.users (id, name, surname, email, birthdate) VALUES (?, ?, ?, ?, ?)"
        val connection = conn.connect()
        val preparedStatement = connection.prepareStatement(sql)

        try {
            val id = UUID.randomUUID().toString()
            preparedStatement.setString(1, id)
            preparedStatement.setString(2, name)
            preparedStatement.setString(3, surname)
            preparedStatement.setString(4, email)
            preparedStatement.setDate(5, java.sql.Date(SimpleDateFormat("dd/MM/yyyy").parse(birthdate).time))
            preparedStatement.executeUpdate()
            Logger.getLogger(UserRepository::class.java.name).info(" Repository - CREATE")
            return User(id, name, surname, email, birthdate)

        } catch (e: SQLException) {
            e.printStackTrace()
            throw e
        } finally {
            preparedStatement.close()
            connection.close()
        }
    }


}