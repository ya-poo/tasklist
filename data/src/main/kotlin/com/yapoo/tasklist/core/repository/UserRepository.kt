package com.yapoo.tasklist.core.repository

import com.yapoo.tasklist.core.dto.create.CreateUserProfile
import com.yapoo.tasklist.core.model.UserProfile
import com.yapoo.tasklist.core.table.UserProfileTable
import com.yapoo.tasklist.core.time.EpochMilliTime
import com.yapoo.tasklist.core.time.SystemClock
import com.yapoo.tasklist.core.time.toEpochMilliTime
import com.yapoo.tasklist.core.valueobject.Email
import com.yapoo.tasklist.core.valueobject.UserName
import com.yapoo.tasklist.core.valueobject.Uuid
import java.util.*

interface UserRepository {

    suspend fun create(createUserProfile: CreateUserProfile): UserProfile

    interface Dependency {
        val systemClock: SystemClock
    }
}

class UserRepositoryImpl(private val d: UserRepository.Dependency) : UserRepository {

    private val internalList: List<UserProfileTable> = mutableListOf()

    override suspend fun create(
        createUserProfile: CreateUserProfile
    ): UserProfile {
        val now = d.systemClock.now().toEpochMilliTime()
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
