package com.yapoo.tasklist.infrastructure.database.migration

import org.flywaydb.core.Flyway
import org.flywaydb.core.api.configuration.ClassicConfiguration
import javax.sql.DataSource

internal fun migrateDatabase(
    dataSource: DataSource
) {
    ClassicConfiguration().apply {
        setDataSource(dataSource)
        Flyway(this).migrate()
    }
}
