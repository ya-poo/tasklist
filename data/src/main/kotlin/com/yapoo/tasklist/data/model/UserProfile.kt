package com.yapoo.tasklist.data.model

import com.yapoo.tasklist.data.valueobject.Email
import com.yapoo.tasklist.data.valueobject.UserName
import com.yapoo.tasklist.data.valueobject.Uuid
import java.time.ZonedDateTime

data class UserProfile(
    val id: Uuid.User,
    val email: Email,
    val fullName: UserName?,
    val kanaName: UserName?,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
)
