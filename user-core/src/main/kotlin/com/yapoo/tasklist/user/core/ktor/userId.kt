package com.yapoo.tasklist.user.core.ktor

import com.yapoo.tasklist.data.core.valueobject.UserId
import com.yapoo.tasklist.user.core.error.UserError
import io.ktor.application.*

fun ApplicationCall.userId() =
    userIdOrNull() ?: throw UserError.BadRequest.UserIdNotSet()

fun ApplicationCall.userIdOrNull() =
    request.headers["X-Tasklist-User"]?.let { UserId.fromText(it) }
