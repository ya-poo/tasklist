package com.yapoo.tasklist.web

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun StatusPages.Configuration.statusPageHandler() {

    exception<Throwable> { cause ->
        call.respond(
            HttpStatusCode.InternalServerError,
            mapOf(
                "code" to "InternalServerError",
                "cause" to cause
            )
        )
    }

    status(HttpStatusCode.NotFound) {
        call.respond(
            HttpStatusCode.NotFound,
            mapOf(
                "code" to "NotFound"
            )
        )
    }
}
