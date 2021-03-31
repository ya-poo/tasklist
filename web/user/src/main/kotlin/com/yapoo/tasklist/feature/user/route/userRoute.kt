package com.yapoo.tasklist.feature.user.route

import com.yapoo.tasklist.feature.user.route.request.UserRequest
import com.yapoo.tasklist.feature.user.usecase.UserUseCase
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.userRoute(userUseCase: UserUseCase) {
    route("users/me") {
        post {
            val request = call.receive<UserRequest>()
            val response = userUseCase.create(request)
            call.respond(HttpStatusCode.OK, response)
        }
    }
}
