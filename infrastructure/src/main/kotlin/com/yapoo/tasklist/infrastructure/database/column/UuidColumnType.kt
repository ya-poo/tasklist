package com.yapoo.tasklist.infrastructure.database.column

import com.yapoo.tasklist.infrastructure.uuid.Uuid
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.UUIDColumnType
import java.util.*

fun <T : Uuid> Table.uuid(wrapper: (UUID) -> T, name: String): Column<T> =
    registerColumn(name, UuidColumnType(wrapper))

private val uuidColumnType = UUIDColumnType()

class UuidColumnType<T : Uuid>(
    private val wrapper: (UUID) -> T
) : ColumnType() {

    override fun sqlType(): String =
        uuidColumnType.sqlType()

    override fun valueFromDB(value: Any): Any = when (value) {
        is Uuid -> value
        is UUID -> wrapper(value)
        else -> uuidColumnType.valueFromDB(value)
    }

    override fun notNullValueToDB(value: Any): Any = when (value) {
        is Uuid -> value.value
        else -> uuidColumnType.notNullValueToDB(value)
    }
}
