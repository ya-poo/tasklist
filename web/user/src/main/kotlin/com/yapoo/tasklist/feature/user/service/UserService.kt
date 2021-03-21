package com.yapoo.tasklist.feature.user.service

import com.yapoo.tasklist.core.dto.create.CreateUserProfile
import com.yapoo.tasklist.core.model.UserProfile
import com.yapoo.tasklist.core.repository.UserRepository
import com.yapoo.tasklist.core.valueobject.Email

interface UserService {

    suspend fun createUser(
        email: Email
    ): UserProfile

    interface Dependency {
        val userRepository: UserRepository
    }
}

internal class UserServiceImpl(private val d: UserService.Dependency) :
    UserService,
    UserService.Dependency by d {

    override suspend fun createUser(
        email: Email
    ): UserProfile {
        return userRepository.create(CreateUserProfile(email))
    }

}
