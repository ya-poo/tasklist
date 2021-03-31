package com.yapoo.tasklist.infrastructure.database.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.Table
import java.time.OffsetDateTime

fun Table.offsetDateTime(name: String): Column<OffsetDateTime> =
    registerColumn(name, OffsetDateTimeColumnType())

class OffsetDateTimeColumnType : ColumnType() {

    override fun sqlType(): String =
        "TIMESTAMP WITH TIME ZONE"

    override fun valueFromDB(value: Any): Any = when (value) {
        is OffsetDateTime -> value
        else -> error("Unexpected Time Value: $value of ${value::class.qualifiedName}")
    }
}
