package com.yapoo.tasklist.ktor

import com.yapoo.tasklist.model.valueobject.UserId
import com.yapoo.tasklist.user.core.ktor.userIdOrNull
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*

fun callLoggingFormat(call: ApplicationCall): String {
    val userId = call.userIdOrNull()

    return userId.toHeader() + when (val status = call.response.status() ?: "Unhandled") {
        HttpStatusCode.Found -> "$status: ${call.request.toLogString()} -> ${call.response.headers[HttpHeaders.Location]}"
        else -> "$status: ${call.request.toLogString()}"
    }
}

private fun UserId?.toHeader() =
    "UserID : ${this?.string ?: "null"} - "
