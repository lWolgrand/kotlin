package org.example.DB

import java.sql.Connection

interface ConnectionInterface {
    fun connect(): Connection
}