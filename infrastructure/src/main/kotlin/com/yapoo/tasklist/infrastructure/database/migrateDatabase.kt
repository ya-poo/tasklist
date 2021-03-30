package com.yapoo.tasklist.infrastructure.database

import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.flywaydb.core.api.configuration.ClassicConfiguration

fun migrateDatabase(
    dataSource: HikariDataSource
) {
    ClassicConfiguration().apply {
        setDataSource(dataSource)
        Flyway(this).migrate()
    }
}
