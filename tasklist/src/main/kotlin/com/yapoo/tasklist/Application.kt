package com.yapoo.tasklist

import com.yapoo.tasklist.di.ApplicationModule
import com.yapoo.tasklist.web.userRoute
import com.yapoo.tasklist.server.applyGracefulShutdown
import com.yapoo.tasklist.web.statusPageHandler
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.slf4j.event.Level

fun main() {
    embeddedServer(
        factory = Netty,
        host = "0.0.0.0",
        port = 8080,
        configure = {
            callGroupSize = Runtime.getRuntime().availableProcessors()
        },
        module = { main() }
    ).applyGracefulShutdown().start()
}

fun Application.main() {

    val module = ApplicationModule()

    install(ContentNegotiation) {
        register(ContentType.Application.Json, JacksonConverter(module.objectMapper))
    }
    install(CallLogging) {
        logger = module.logger
        level = Level.INFO
        filter { call -> call.request.path() != "/health" }
    }
    install(StatusPages) {
        statusPageHandler()
    }

    routing {
        userRoute(module)

        get("/health") {
            call.respondText(GIT_SHA, contentType = ContentType.Text.Plain)
        }
    }

    log.info("GIT_SHA: $GIT_SHA")
}

private val GIT_SHA by System.getenv().withDefault { "local" }
