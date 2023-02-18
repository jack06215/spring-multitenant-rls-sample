package com.example.backend.infrastructure.database.generated.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object CustomerDynamicSqlSupport {
    object Customer : SqlTable("sample.customer") {
        val customerId = column<Long>("customer_id", JDBCType.BIGINT)

        val firstName = column<String>("first_name", JDBCType.VARCHAR)

        val lastName = column<String>("last_name", JDBCType.VARCHAR)

        val tenantName = column<String>("tenant_name", JDBCType.VARCHAR)
    }
}