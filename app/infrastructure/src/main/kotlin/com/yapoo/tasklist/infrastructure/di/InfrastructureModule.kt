package com.yapoo.tasklist.infrastructure.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.yapoo.tasklist.infrastructure.database.connection.TransactionCoroutineDispatcher
import com.yapoo.tasklist.infrastructure.database.connection.TransactionCoroutineDispatcherImpl
import com.yapoo.tasklist.infrastructure.database.connection.createHikariDataSource
import com.yapoo.tasklist.infrastructure.database.migration.migrateDatabase
import com.yapoo.tasklist.infrastructure.jackson.configure
import com.yapoo.tasklist.infrastructure.time.SystemClock
import com.yapoo.tasklist.infrastructure.time.SystemClockImpl
import com.yapoo.tasklist.infrastructure.uuid.UuidFactory
import com.yapoo.tasklist.infrastructure.uuid.UuidFactoryImpl
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class InfrastructureModule :
    InfrastructureModuleRegistry,
    InfrastructureExportToRepositoryRegistry,
    InfrastructureExportToApplicationRegistry {

    override val systemClock: SystemClock by lazy { SystemClockImpl() }

    override val objectMapper: ObjectMapper by lazy {
        jacksonObjectMapper().also(ObjectMapper::configure)
    }

    override val logger: Logger by lazy {
        LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)
    }

    private val dataSource: HikariDataSource by lazy(::createHikariDataSource)

    override val database: Database = Database.connect(dataSource).apply {
        migrateDatabase(dataSource)
    }

    override val dispatcher: TransactionCoroutineDispatcher by lazy {
        TransactionCoroutineDispatcherImpl(this)
    }

    override val uuidFactory: UuidFactory by lazy {
        UuidFactoryImpl()
    }
}
