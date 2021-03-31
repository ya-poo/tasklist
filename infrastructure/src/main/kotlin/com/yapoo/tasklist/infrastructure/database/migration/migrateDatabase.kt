package com.yapoo.tasklist.infrastructure.database.migration

import com.zaxxer.hikari.HikariDataSource
import org.flywaydb.core.Flyway
import org.flywaydb.core.api.configuration.ClassicConfiguration

internal fun migrateDatabase(
    dataSource: HikariDataSource
) {
    ClassicConfiguration().apply {
        setDataSource(dataSource)
        Flyway(this).migrate()
    }
}
