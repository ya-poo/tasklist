package com.yapoo.tasklist.data.table

import com.yapoo.tasklist.infrastructure.database.column.utcDateTime
import com.yapoo.tasklist.infrastructure.database.column.uuid
import com.yapoo.tasklist.infrastructure.valueobject.Uuid
import org.jetbrains.exposed.dao.id.IdTable

object UserProfileTable : IdTable<Uuid.User>("user_profile") {
    override
    val id = uuid(Uuid::User, "id").entityId()
    val email = text("email").index()
    val createdAt = utcDateTime("created_at")
    val updatedAt = utcDateTime("updated_at")

    override val primaryKey = PrimaryKey(id)
}
