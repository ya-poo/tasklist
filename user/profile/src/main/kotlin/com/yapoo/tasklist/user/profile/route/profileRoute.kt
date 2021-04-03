package com.yapoo.tasklist.user.profile.route

import com.yapoo.tasklist.user.core.ktor.userId
import com.yapoo.tasklist.user.profile.route.request.UserRequest
import com.yapoo.tasklist.user.profile.usecase.UserUseCase
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.profileRoute(userUseCase: UserUseCase) {
    post {
        val request = call.receive<UserRequest>()
        val response = userUseCase.create(request)
        call.respond(HttpStatusCode.OK, response)
    }
    get {
        val userId = call.userId()
        val response = userUseCase.find(userId)
        call.respond(HttpStatusCode.OK, response)
    }
}
