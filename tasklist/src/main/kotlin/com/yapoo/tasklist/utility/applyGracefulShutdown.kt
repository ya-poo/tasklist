package com.yapoo.tasklist.utility

import io.ktor.server.engine.*
import java.util.concurrent.TimeUnit

fun ApplicationEngine.applyGracefulShutdown() = also { engine ->
    Runtime
        .getRuntime()
        .addShutdownHook(Thread {
            engine.stop(6, 10, TimeUnit.SECONDS)
        })
}
