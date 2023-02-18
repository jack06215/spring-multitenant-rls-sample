package com.example.backend.datasource

import com.example.backend.core.ThreadLocalStorage
import com.zaxxer.hikari.HikariDataSource
import java.sql.Connection
import java.sql.SQLException

class TenantAwareHikariDataSource : HikariDataSource() {
    @Throws(SQLException::class)
    override fun getConnection(): Connection {
        val connection = super.getConnection()
        val sql = connection.createStatement()
        sql.execute("SET app.current_tenant = '" + ThreadLocalStorage.getTenantName() + "'")
        return connection
    }

    @Throws(SQLException::class)
    override fun getConnection(username: String, password: String): Connection {
        val connection = super.getConnection(username, password)
        val sql = connection.createStatement()
        sql.execute("SET app.current_tenant = '" + ThreadLocalStorage.getTenantName() + "'")
        return connection
    }
}
