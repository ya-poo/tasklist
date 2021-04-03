package com.yapoo.tasklist.data.table

import com.yapoo.tasklist.infrastructure.database.column.utcDateTime
import com.yapoo.tasklist.infrastructure.database.column.uuid
import com.yapoo.tasklist.infrastructure.valueobject.Uuid
import org.jetbrains.exposed.sql.Table

object UserProfileTable : Table("user_profile") {
    val id = uuid(Uuid::User, "id")
    val email = text("email").index()
    val createdAt = utcDateTime("created_at")
    val updatedAt = utcDateTime("updated_at")
}
