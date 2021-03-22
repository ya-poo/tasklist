package com.yapoo.tasklist.feature.user.web.response

import com.yapoo.tasklist.data.core.model.UserProfile
import com.yapoo.tasklist.data.core.valueobject.Email
import com.yapoo.tasklist.data.core.valueobject.UserName
import com.yapoo.tasklist.data.core.valueobject.Uuid
import java.time.ZonedDateTime

data class UserResponse(
    val id: Uuid.User,
    val email: Email,
    val fullName: UserName?,
    val kanaName: UserName?,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
) {

    companion object {
        fun from(userProfile: UserProfile) = userProfile.run {
            UserResponse(
                id = id,
                email = email,
                fullName = fullName,
                kanaName = kanaName,
                createdAt = createdAt,
                updatedAt = updatedAt
            )
        }
    }
}

internal fun UserProfile.toUserResponse() = UserResponse.from(this)
