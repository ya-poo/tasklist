package com.yapoo.tasklist.repository.dto

import com.yapoo.tasklist.repository.core.valueobject.Email

data class CreateUserProfile(
    val email: Email,
)
