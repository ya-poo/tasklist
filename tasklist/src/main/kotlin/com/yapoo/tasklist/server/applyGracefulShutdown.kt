package com.yapoo.tasklist.server

import io.ktor.server.engine.*
import java.util.concurrent.TimeUnit

fun ApplicationEngine.applyGracefulShutdown() = also { engine ->
    Runtime
        .getRuntime()
        .addShutdownHook(Thread {
            engine.stop(6, 10, TimeUnit.SECONDS)
        })
}
