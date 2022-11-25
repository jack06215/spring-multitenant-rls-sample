package com.example.backend.infrastructure.database.mapper

import java.sql.JDBCType
import org.mybatis.dynamic.sql.SqlTable

object UserDynamicSqlSupport {
    object User : SqlTable("public.user") {
        val id = column<Long>("id", JDBCType.BIGINT)

        val name = column<String>("name", JDBCType.VARCHAR)

        val age = column<Long>("age", JDBCType.BIGINT)

        val profile = column<String>("profile", JDBCType.VARCHAR)
    }
}