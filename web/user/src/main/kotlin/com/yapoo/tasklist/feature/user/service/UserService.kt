package com.yapoo.tasklist.feature.user.service

import com.yapoo.tasklist.data.core.model.UserProfile
import com.yapoo.tasklist.data.core.valueobject.Email
import com.yapoo.tasklist.data.dto.CreateUserProfile
import com.yapoo.tasklist.data.repository.UserRepository

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
