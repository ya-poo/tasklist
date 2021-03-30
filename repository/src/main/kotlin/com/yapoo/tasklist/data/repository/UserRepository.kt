package com.yapoo.tasklist.data.repository

import com.yapoo.tasklist.data.core.model.UserProfile
import com.yapoo.tasklist.data.core.valueobject.Email
import com.yapoo.tasklist.data.core.valueobject.UserName
import com.yapoo.tasklist.data.core.valueobject.Uuid
import com.yapoo.tasklist.data.dto.create.CreateUserProfile
import com.yapoo.tasklist.infrastructure.time.EpochMilliTime
import com.yapoo.tasklist.infrastructure.time.SystemClock
import com.yapoo.tasklist.infrastructure.time.toEpochMilliTime
import java.util.*

interface UserRepository {

    suspend fun create(createUserProfile: CreateUserProfile): UserProfile

    interface Dependency {
        val systemClock: SystemClock
    }
}

internal class UserRepositoryImpl(private val d: UserRepository.Dependency) :
    UserRepository,
    UserRepository.Dependency by d {

    private val internalList: List<UserProfileTable> = mutableListOf()

    private data class UserProfileTable(
        val id: Uuid.User,
        val email: String,
        val fullName: String? = null,
        val kanaName: String? = null,
        val createdAt: Long,
        val updatedAt: Long
    )

    override suspend fun create(
        createUserProfile: CreateUserProfile
    ): UserProfile {
        val now = systemClock.now().toEpochMilliTime()
        val user = UserProfileTable(
            id = UUID.randomUUID().let(Uuid::User),
            email = createUserProfile.email.value,
            createdAt = now.value,
            updatedAt = now.value,
        )
        internalList.plus(user)

        return UserProfile(
            id = user.id,
            email = user.email.let(::Email),
            fullName = user.fullName?.let(::UserName),
            kanaName = user.kanaName?.let(::UserName),
            createdAt = EpochMilliTime(user.createdAt).toZonedDateTime(),
            updatedAt = EpochMilliTime(user.updatedAt).toZonedDateTime()
        )
    }
}
