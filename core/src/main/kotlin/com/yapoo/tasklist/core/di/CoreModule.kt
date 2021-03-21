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
    CoreExportToDataRegistry,
    CoreExportToApplicationRegistry {

    override val systemClock: SystemClock by lazy { SystemClockImpl() }

    override val objectMapper: ObjectMapper by lazy {
        jacksonObjectMapper().also(ObjectMapper::configure)
    }

    override val logger: Logger by lazy {
        LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)
    }
}

fun CoreModule.toDataExportRegistry(): CoreExportToDataRegistry = this

fun CoreModule.toApplicationExportRegistry(): CoreExportToApplicationRegistry = this

