package com.yapoo.tasklist.feature.user.web

import com.yapoo.tasklist.feature.user.di.UserModule
import com.yapoo.tasklist.feature.user.web.request.UserRequest
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.userRoute(module: UserModule) = module.run {
    route("users/me") {
        post {
            val request = call.receive<UserRequest>()
            val response = userUseCase.create(request)
            call.respond(HttpStatusCode.OK, response)
        }
    }
}