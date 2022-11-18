package com.example.backend.infrastructure.database.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object CustomerDynamicSqlSupport {
    object Customer : SqlTable("customer") {
        val customerId = column<Int>("customer_id", JDBCType.INTEGER)

        val firstName = column<String>("first_name", JDBCType.VARCHAR)

        val lastName = column<String>("last_name", JDBCType.VARCHAR)

        val tenantName = column<String>("tenant_name", JDBCType.VARCHAR)
    }
}