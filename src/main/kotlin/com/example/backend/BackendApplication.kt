package com.example.backend

import com.example.backend.infrastructure.datasource.TenantAwareHikariDataSource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
class BackendApplication {
    @Bean
    fun dataSource(): DataSource {
        val dataSource = TenantAwareHikariDataSource()

        dataSource.initializationFailTimeout = 0
        dataSource.maximumPoolSize = 5
        dataSource.dataSourceClassName = "org.postgresql.ds.PGSimpleDataSource"
        // dataSource.setDataSourceClassName("org.postgresql.Driver")
        dataSource.addDataSourceProperty("url", "jdbc:postgresql://127.0.0.1:5434/example_rls")
        dataSource.addDataSourceProperty("user", "app_user")
        dataSource.addDataSourceProperty("password", "app_user")

        return dataSource
    }
}

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}
