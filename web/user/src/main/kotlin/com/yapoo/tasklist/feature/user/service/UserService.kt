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

class UserServiceImpl(private val d: UserService.Dependency) : UserService {

    override suspend fun createUser(
        email: Email
    ): UserProfile {
        return d.userRepository.create(CreateUserProfile(email))
    }

}