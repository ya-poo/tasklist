package com.yapoo.tasklist.model.model

import com.yapoo.tasklist.model.valueobject.Email
import com.yapoo.tasklist.model.valueobject.UserId
import com.yapoo.tasklist.infrastructure.valueobject.datetime.UtcDateTime

data class UserProfile(
    val id: UserId,
    val email: Email,
    val createdAt: UtcDateTime,
    val updatedAt: UtcDateTime,
)
