package com.yapoo.tasklist.data.repository

import com.yapoo.tasklist.data.core.model.UserProfile
import com.yapoo.tasklist.data.core.valueobject.Email
import com.yapoo.tasklist.data.dto.CreateUserProfile
import com.yapoo.tasklist.data.table.UserProfileTable
import com.yapoo.tasklist.infrastructure.database.connection.TransactionCoroutineDispatcher
import com.yapoo.tasklist.infrastructure.time.SystemClock
import com.yapoo.tasklist.infrastructure.uuid.UuidFactory
import com.yapoo.tasklist.infrastructure.valueobject.Uuid
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.statements.InsertStatement

interface UserRepository {

    suspend fun create(createUserProfile: CreateUserProfile): UserProfile

    interface Dependency {
        val systemClock: SystemClock
        val dispatcher: TransactionCoroutineDispatcher
        val uuidFactory: UuidFactory
    }
}

internal class UserRepositoryImpl(private val d: UserRepository.Dependency) :
    UserRepository,
    UserRepository.Dependency by d {

    override suspend fun create(
        createUserProfile: CreateUserProfile
    ): UserProfile {
        val now = systemClock.now()

        return dispatcher.transaction {
            UserProfileTable.insert {
                it[id] = Uuid.User(uuidFactory.next())
                it[email] = createUserProfile.email.value
                it[createdAt] = now
                it[updatedAt] = now
            }
        }.toUserProfile()
    }

    private fun InsertStatement<*>.toUserProfile() =
        UserProfile(
            id = this[UserProfileTable.id],
            email = this[UserProfileTable.email].let(::Email),
            createdAt = this[UserProfileTable.createdAt],
            updatedAt = this[UserProfileTable.updatedAt]
        )
}
