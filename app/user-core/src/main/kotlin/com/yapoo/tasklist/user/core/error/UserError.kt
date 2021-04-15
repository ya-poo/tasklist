package com.yapoo.tasklist.user.core.error

import io.ktor.http.*

sealed class UserError(
    message: String,
    val statusCode: HttpStatusCode,
    cause: Throwable? = null,
) : Throwable(message, cause) {

    sealed class BadRequest(message: String) : UserError(message, HttpStatusCode.BadRequest) {

        class UserIdNotSet : BadRequest("ユーザーID が指定されていません。")

    }

    sealed class NotFound(message: String) : UserError(message, HttpStatusCode.NotFound) {

        class UserNotFound : NotFound("ユーザーが存在しません")

    }
}
