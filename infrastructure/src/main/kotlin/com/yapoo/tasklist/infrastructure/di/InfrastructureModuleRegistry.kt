package com.yapoo.tasklist.infrastructure.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.yapoo.tasklist.infrastructure.database.connection.TransactionCoroutineDispatcher
import com.yapoo.tasklist.infrastructure.time.SystemClock
import com.yapoo.tasklist.infrastructure.uuid.UuidFactory
import org.slf4j.Logger

interface InfrastructureModuleRegistry
    : TransactionCoroutineDispatcher.Dependencies

interface InfrastructureExportToRepositoryRegistry {
    val systemClock: SystemClock
    val dispatcher: TransactionCoroutineDispatcher
    val uuidFactory: UuidFactory
}

interface InfrastructureExportToApplicationRegistry {
    val objectMapper: ObjectMapper
    val logger: Logger
}
