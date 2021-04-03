package com.yapoo.tasklist.user.core.ktor

import com.yapoo.tasklist.data.core.valueobject.UserId
import com.yapoo.tasklist.user.core.error.UserError
import io.ktor.application.*

fun ApplicationCall.userId() =
    request.headers["X-Tasklist-User"]?.let { UserId.fromText(it) }
        ?: throw UserError.BadRequest.UserIdNotSet()
