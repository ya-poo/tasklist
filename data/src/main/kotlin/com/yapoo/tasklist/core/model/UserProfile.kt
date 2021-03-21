package com.yapoo.tasklist.core.model

import com.yapoo.tasklist.core.valueobject.Email
import com.yapoo.tasklist.core.valueobject.UserName
import com.yapoo.tasklist.core.valueobject.Uuid
import java.time.ZonedDateTime

data class UserProfile(
    val id: Uuid.User,
    val email: Email,
    val fullName: UserName?,
    val kanaName: UserName?,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
)
