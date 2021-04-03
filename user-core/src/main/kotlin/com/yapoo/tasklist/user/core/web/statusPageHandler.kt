package com.yapoo.tasklist.user.core.web

import com.yapoo.tasklist.user.core.error.UserError
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*

fun StatusPages.Configuration.userStatusPageHandler() {

    exception<UserError> { cause ->
        call.respond(cause.statusCode, cause)
    }
}
