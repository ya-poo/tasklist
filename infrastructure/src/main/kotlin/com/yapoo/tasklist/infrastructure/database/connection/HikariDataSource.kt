package com.yapoo.tasklist.infrastructure.database.connection

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

private const val dbname = "tasklist"

internal fun createHikariDataSource() = HikariDataSource(
    HikariConfig().apply {
        driverClassName = "org.postgresql.Driver"
        jdbcUrl = "jdbc:postgresql://localhost:5432/$dbname"
        maximumPoolSize = 100
        minimumIdle = 1
        isAutoCommit = false
        connectionTimeout = 10000
        idleTimeout = 60000
        maxLifetime = 120000
        connectionInitSql = "SELECT 1"

        addDataSourceProperty("user", "root")
        addDataSourceProperty("password", "password")
        addDataSourceProperty("characterEncoding", "utf8")
        addDataSourceProperty("useUnicode", "true")

        validate()
    }
)
