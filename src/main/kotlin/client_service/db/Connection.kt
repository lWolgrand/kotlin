package client_service.db

import java.sql.Connection
import java.sql.DriverManager

class Connection: ConnectionInterface {
    private val url = "jdbc:mysql://localhost:3306/crud"
    private val username = "admin"
    private val password = "root"

    override fun connect(): Connection {
        return DriverManager.getConnection(url, username, password)
    }

}
