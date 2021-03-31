package com.yapoo.tasklist.data.core.model

import com.yapoo.tasklist.data.core.valueobject.Email
import com.yapoo.tasklist.data.core.valueobject.Uuid
import com.yapoo.tasklist.infrastructure.time.UtcDateTime

data class UserProfile(
    val id: Uuid.User,
    val email: Email,
    val createdAt: UtcDateTime,
    val updatedAt: UtcDateTime,
)
