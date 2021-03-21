package com.yapoo.tasklist

import com.fasterxml.jackson.databind.SerializationFeature
import com.yapoo.tasklist.di.buildModule
import com.yapoo.tasklist.feature.user.web.userRoute
import com.yapoo.tasklist.utility.applyGracefulShutdown
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
import java.util.concurrent.TimeUnit

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

fun Application.main() = buildModule().run {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path() != "/health" }
    }

    routing {
        userRoute(user)

        get("/health") {
            call.respondText(GIT_SHA, contentType = ContentType.Text.Plain)
        }
    }
}

private val GIT_SHA by System.getenv().withDefault { "local" }
