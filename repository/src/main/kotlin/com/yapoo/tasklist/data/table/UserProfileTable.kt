package com.yapoo.tasklist.data.table

import com.yapoo.tasklist.infrastructure.database.table.offsetDateTime
import org.jetbrains.exposed.sql.Table

object UserProfileTable : Table("user_profile") {
    val id = uuid("id")
    val email = varchar("email", 255)
    val createdAt = offsetDateTime("created_at")
    val updatedAt = offsetDateTime("updated_at")
}
