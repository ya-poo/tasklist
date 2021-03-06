package com.yapoo.tasklist.repository.repository

import com.yapoo.tasklist.repository.model.UserProfile
import com.yapoo.tasklist.repository.valueobject.Email
import com.yapoo.tasklist.repository.valueobject.UserId
import com.yapoo.tasklist.repository.dto.CreateUserProfile
import com.yapoo.tasklist.repository.table.UserProfileTable
import com.yapoo.tasklist.infrastructure.database.connection.TransactionCoroutineDispatcher
import com.yapoo.tasklist.infrastructure.time.SystemClock
import com.yapoo.tasklist.infrastructure.uuid.UuidFactory
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.statements.InsertStatement

interface UserRepository {

    suspend fun create(
        createUserProfile: CreateUserProfile
    ): UserProfile

    suspend fun find(
        userId: UserId
    ): UserProfile?

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
                it[id] = UserId(uuidFactory.next())
                it[email] = createUserProfile.email.value
                it[createdAt] = now
                it[updatedAt] = now
            }
        }.toUserProfile()
    }

    override suspend fun find(
        userId: UserId
    ): UserProfile? {
        return dispatcher.transaction {
            UserProfileTable
                .select {
                    UserProfileTable.id eq userId
                }
                .singleOrNull()
                ?.toUserProfile()
        }
    }

    private fun InsertStatement<*>.toUserProfile() =
        UserProfile(
            id = this[UserProfileTable.id],
            email = this[UserProfileTable.email].let(::Email),
            createdAt = this[UserProfileTable.createdAt],
            updatedAt = this[UserProfileTable.updatedAt]
        )

    private fun ResultRow.toUserProfile() =
        UserProfile(
            id = this[UserProfileTable.id],
            email = this[UserProfileTable.email].let(::Email),
            createdAt = this[UserProfileTable.createdAt],
            updatedAt = this[UserProfileTable.updatedAt]
        )
}
