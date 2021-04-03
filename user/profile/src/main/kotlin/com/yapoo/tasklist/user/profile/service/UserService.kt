package com.yapoo.tasklist.user.profile.service

import com.yapoo.tasklist.repository.core.model.UserProfile
import com.yapoo.tasklist.repository.core.valueobject.Email
import com.yapoo.tasklist.repository.core.valueobject.UserId
import com.yapoo.tasklist.repository.dto.CreateUserProfile
import com.yapoo.tasklist.repository.repository.UserRepository

interface UserService {

    suspend fun createUser(
        email: Email
    ): UserProfile

    suspend fun findUser(
        userId: UserId
    ): UserProfile?

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

    override suspend fun findUser(
        userId: UserId
    ): UserProfile? {
        return userRepository.find(userId)
    }
}
