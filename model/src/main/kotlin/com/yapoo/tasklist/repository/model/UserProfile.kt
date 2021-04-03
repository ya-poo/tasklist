package com.yapoo.tasklist.repository.model

import com.yapoo.tasklist.repository.valueobject.Email
import com.yapoo.tasklist.repository.valueobject.UserId
import com.yapoo.tasklist.infrastructure.valueobject.datetime.UtcDateTime

data class UserProfile(
    val id: UserId,
    val email: Email,
    val createdAt: UtcDateTime,
    val updatedAt: UtcDateTime,
)
