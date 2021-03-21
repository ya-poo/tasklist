package com.yapoo.tasklist.feature.user.usecase

import com.yapoo.tasklist.feature.user.service.UserService
import com.yapoo.tasklist.feature.user.web.request.UserRequest
import com.yapoo.tasklist.feature.user.web.response.UserResponse
import com.yapoo.tasklist.feature.user.web.response.toUserResponse

interface UserUseCase {

    suspend fun create(
        request: UserRequest
    ): UserResponse

    interface Dependency {
        val userService: UserService
    }
}

class UserUseCaseImpl(private val d: UserUseCase.Dependency) :
    UserUseCase,
    UserUseCase.Dependency by d {

    override suspend fun create(
        request: UserRequest
    ): UserResponse {
        return userService.createUser(request.email).toUserResponse()
    }

}
