package com.yapoo.tasklist.data.table

import org.jetbrains.exposed.sql.Table

object UserProfileTable : Table("user_profile") {
    val id = uuid("id")
    val email = varchar("email", 255)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}
