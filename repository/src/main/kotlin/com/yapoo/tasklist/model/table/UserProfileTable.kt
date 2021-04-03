package com.yapoo.tasklist.model.table

import com.yapoo.tasklist.model.valueobject.UserId
import com.yapoo.tasklist.infrastructure.database.column.utcDateTime
import com.yapoo.tasklist.infrastructure.database.column.uuid
import org.jetbrains.exposed.sql.Table

object UserProfileTable : Table("user_profile") {
    val id = uuid(::UserId, "id")
    val email = text("email")
    val createdAt = utcDateTime("created_at")
    val updatedAt = utcDateTime("updated_at")
}
