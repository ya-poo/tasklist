package com.yapoo.tasklist.infrastructure.database.column

import com.yapoo.tasklist.infrastructure.valueobject.Uuid
import com.yapoo.tasklist.infrastructure.valueobject.toUuid
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.UUIDColumnType
import java.util.*

fun <T : Uuid> Table.uuid(factory: (UUID) -> T, name: String): Column<T> =
    registerColumn(name, UuidColumnType(factory))

inline fun <reified T : Uuid> IdTable<T>.entityId(id: UUID): EntityID<T> =
    EntityID(id.toUuid(), this)

private val uuidColumnType = UUIDColumnType()

class UuidColumnType<T : Uuid>(
    private val factory: (UUID) -> T
) : ColumnType() {

    override fun sqlType(): String =
        uuidColumnType.sqlType()

    override fun valueFromDB(value: Any): Any = when (value) {
        is Uuid -> value
        is UUID -> factory(value)
        else -> uuidColumnType.valueFromDB(value)
    }

    override fun notNullValueToDB(value: Any): Any = when (value) {
        is Uuid -> value.value
        else -> uuidColumnType.notNullValueToDB(value)
    }
}
