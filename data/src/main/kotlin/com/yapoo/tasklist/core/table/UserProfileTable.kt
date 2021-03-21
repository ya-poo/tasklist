package com.yapoo.tasklist.core.table

import com.yapoo.tasklist.core.valueobject.Uuid

data class UserProfileTable(
    val id: Uuid.User,
    val email: String,
    val fullName: String? = null,
    val kanaName: String? = null,
    val createdAt: Long,
    val updatedAt: Long,
)
