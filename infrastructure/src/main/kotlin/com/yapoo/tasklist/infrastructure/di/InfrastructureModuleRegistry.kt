package com.yapoo.tasklist.infrastructure.di

import com.fasterxml.jackson.databind.ObjectMapper
import com.yapoo.tasklist.infrastructure.time.SystemClock
import org.slf4j.Logger

interface InfrastructureModuleRegistry

interface InfrastructureExportToDataRegistry {
    val systemClock: SystemClock
}

interface InfrastructureExportToApplicationRegistry {
    val objectMapper: ObjectMapper
    val logger: Logger
}
