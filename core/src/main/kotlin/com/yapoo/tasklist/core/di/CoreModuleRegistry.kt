package com.yapoo.tasklist.core.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.yapoo.tasklist.core.time.SystemClock
import org.slf4j.Logger

interface CoreModuleRegistry

interface CoreExportToDataRegistry {
    val systemClock: SystemClock
}

interface CoreExportToApplicationRegistry {
    val objectMapper: ObjectMapper
    val logger: Logger
}
