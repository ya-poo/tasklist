package com.yapoo.tasklist.user.core.ktor

import com.yapoo.tasklist.infrastructure.valueobject.Uuid
import com.yapoo.tasklist.user.core.error.UserError
import io.ktor.application.*

fun ApplicationCall.userId() =
    request.headers["X-Tasklist-User"]?.let { Uuid.User.fromText(it) }
        ?: throw UserError.BadRequest.UserIdNotSet()
