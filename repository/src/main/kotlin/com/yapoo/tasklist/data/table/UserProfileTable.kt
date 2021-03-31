package com.yapoo.tasklist.data.table

import com.yapoo.tasklist.infrastructure.database.column.utcDateTime
import com.yapoo.tasklist.infrastructure.database.column.uuid
import com.yapoo.tasklist.infrastructure.valueobject.Uuid
import org.jetbrains.exposed.dao.IdTable

object UserProfileTable : IdTable<Uuid.User>("user_profile") {
    override val id = uuid(Uuid::User, "id").primaryKey().entityId()
    val email = text("email")
    val createdAt = utcDateTime("created_at")
    val updatedAt = utcDateTime("updated_at")
}
