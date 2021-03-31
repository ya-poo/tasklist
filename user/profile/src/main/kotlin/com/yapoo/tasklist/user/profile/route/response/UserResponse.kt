package com.yapoo.tasklist.user.profile.route.response

import com.yapoo.tasklist.data.core.model.UserProfile
import com.yapoo.tasklist.data.core.valueobject.Email
import com.yapoo.tasklist.infrastructure.valueobject.Uuid
import com.yapoo.tasklist.infrastructure.valueobject.datetime.TokyoDateTime

data class UserResponse(
    val id: Uuid.User,
    val email: Email,
    val createdAt: TokyoDateTime,
    val updatedAt: TokyoDateTime,
) {

    companion object {
        fun from(userProfile: UserProfile) = userProfile.run {
            UserResponse(
                id = id,
                email = email,
                createdAt = createdAt.toTokyoDateTime(),
                updatedAt = updatedAt.toTokyoDateTime()
            )
        }
    }
}

internal fun UserProfile.toUserResponse() = UserResponse.from(this)
