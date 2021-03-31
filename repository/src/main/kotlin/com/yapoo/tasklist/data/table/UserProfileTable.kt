package com.yapoo.tasklist.data.table

import com.yapoo.tasklist.infrastructure.database.column.utcDateTime
import org.jetbrains.exposed.sql.Table

object UserProfileTable : Table("user_profile") {
    val id = uuid("id")
    val email = varchar("email", 255)
    val createdAt = utcDateTime("created_at")
    val updatedAt = utcDateTime("updated_at")
}
