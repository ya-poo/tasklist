package com.yapoo.tasklist.user.profile.usecase

import com.yapoo.tasklist.model.valueobject.UserId
import com.yapoo.tasklist.user.core.error.UserError
import com.yapoo.tasklist.user.profile.route.request.UserRequest
import com.yapoo.tasklist.user.profile.route.response.UserResponse
import com.yapoo.tasklist.user.profile.route.response.toUserResponse
import com.yapoo.tasklist.user.profile.service.UserService

interface UserUseCase {

    suspend fun create(
        request: UserRequest
    ): UserResponse

    suspend fun find(
        userId: UserId
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

    override suspend fun find(
        userId: UserId
    ): UserResponse {
        return userService.findUser(userId)
            ?.toUserResponse()
            ?: throw UserError.NotFound.UserNotFound()
    }
}
