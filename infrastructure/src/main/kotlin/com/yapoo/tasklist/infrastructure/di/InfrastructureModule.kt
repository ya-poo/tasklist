package com.yapoo.tasklist.infrastructure.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.yapoo.tasklist.infrastructure.jackson.configure
import com.yapoo.tasklist.infrastructure.time.SystemClock
import com.yapoo.tasklist.infrastructure.time.SystemClockImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class InfrastructureModule :
    InfrastructureModuleRegistry,
    InfrastructureExportToDataRegistry,
    InfrastructureExportToApplicationRegistry {

    override val systemClock: SystemClock by lazy { SystemClockImpl() }

    override val objectMapper: ObjectMapper by lazy {
        jacksonObjectMapper().also(ObjectMapper::configure)
    }

    override val logger: Logger by lazy {
        LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)
    }
}
