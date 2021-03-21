package com.yapoo.tasklist.core.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.yapoo.tasklist.core.jackson.configure
import com.yapoo.tasklist.core.time.SystemClock
import com.yapoo.tasklist.core.time.SystemClockImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CoreModule :
    CoreModuleRegistry,
    CoreExportToDataRegistry {

    override val systemClock: SystemClock by lazy { SystemClockImpl() }

    val objectMapper: ObjectMapper by lazy {
        jacksonObjectMapper().also(ObjectMapper::configure)
    }

    val logger: Logger by lazy {
        LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)
    }
}

fun CoreModule.toCoreExportToDataRegistry() =
    object : CoreExportToDataRegistry by this {}
