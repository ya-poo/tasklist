package com.yapoo.tasklist.feature.user.web.response

import com.yapoo.tasklist.data.core.model.UserProfile
import com.yapoo.tasklist.data.core.valueobject.Email
import com.yapoo.tasklist.data.core.valueobject.Uuid
import com.yapoo.tasklist.infrastructure.time.UtcDateTime
import java.time.ZonedDateTime

data class UserResponse(
    val id: Uuid.User,
    val email: Email,
    val createdAt: UtcDateTime,
    val updatedAt: UtcDateTime,
) {

    companion object {
        fun from(userProfile: UserProfile) = userProfile.run {
            UserResponse(
                id = id,
                email = email,
                createdAt = createdAt,
                updatedAt = updatedAt
            )
        }
    }
}

internal fun UserProfile.toUserResponse() = UserResponse.from(this)
