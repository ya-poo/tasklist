package com.yapoo.tasklist.user.profile.route.response

import com.yapoo.tasklist.repository.model.UserProfile
import com.yapoo.tasklist.repository.valueobject.Email
import com.yapoo.tasklist.repository.valueobject.UserId
import com.yapoo.tasklist.infrastructure.valueobject.datetime.TokyoDateTime

data class UserResponse(
    val id: UserId,
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
