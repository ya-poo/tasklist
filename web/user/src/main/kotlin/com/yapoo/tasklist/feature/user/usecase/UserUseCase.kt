package com.yapoo.tasklist.feature.user.usecase

import com.yapoo.tasklist.feature.user.route.request.UserRequest
import com.yapoo.tasklist.feature.user.route.response.UserResponse
import com.yapoo.tasklist.feature.user.route.response.toUserResponse
import com.yapoo.tasklist.feature.user.service.UserService

interface UserUseCase {

    suspend fun create(
        request: UserRequest
    ): UserResponse

    interface Dependency {
        val userService: UserService
    }
}

internal class UserUseCaseImpl(private val d: UserUseCase.Dependency) :
    UserUseCase,
    UserUseCase.Dependency by d {

    override suspend fun create(
        request: UserRequest
    ): UserResponse {
        return userService.createUser(request.email).toUserResponse()
    }

}
