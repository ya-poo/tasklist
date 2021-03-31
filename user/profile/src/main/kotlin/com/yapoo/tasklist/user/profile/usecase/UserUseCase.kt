package com.yapoo.tasklist.user.profile.usecase

import com.yapoo.tasklist.user.profile.route.request.UserRequest
import com.yapoo.tasklist.user.profile.route.response.UserResponse
import com.yapoo.tasklist.user.profile.route.response.toUserResponse
import com.yapoo.tasklist.user.profile.service.UserService

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
