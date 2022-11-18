package com.example.backend

import com.example.backend.datasource.TenantAwareHikariDataSource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.context.annotation.Bean

import javax.sql.DataSource;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
class BackendApplication {
  @Bean
  fun dataSource(): DataSource {
    val dataSource = TenantAwareHikariDataSource()

    dataSource.setInitializationFailTimeout(0)
    dataSource.setMaximumPoolSize(5)
    dataSource.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource")
    // dataSource.setDataSourceClassName("org.postgresql.Driver")
    dataSource.addDataSourceProperty("url", "jdbc:postgresql://127.0.0.1:5433/sampledb")
    dataSource.addDataSourceProperty("user", "app_user")
    dataSource.addDataSourceProperty("password", "app_user")

    return dataSource
  }
}

fun main(args: Array<String>) {
  runApplication<BackendApplication>(*args)
}
