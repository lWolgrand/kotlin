package client_service.db

import java.sql.Connection

interface ConnectionInterface {
    fun connect(): Connection
}