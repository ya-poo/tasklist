package com.yapoo.tasklist.infrastructure.database.column

import com.yapoo.tasklist.infrastructure.time.UtcDateTime
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.Table
import java.time.OffsetDateTime

fun Table.utcDateTime(name: String): Column<UtcDateTime> =
    registerColumn(name, OffsetDateTimeColumnType())

class OffsetDateTimeColumnType : ColumnType() {

    override fun sqlType(): String =
        "TIMESTAMP WITH TIME ZONE"

    override fun valueFromDB(value: Any): Any = when (value) {
        is OffsetDateTime -> UtcDateTime(value.toZonedDateTime())
        is UtcDateTime -> value
        else -> error("Unexpected Time Value: $value of ${value::class.qualifiedName}")
    }

    override fun valueToDB(value: Any?): Any? = when (value) {
        is UtcDateTime -> value.value.toOffsetDateTime()
        null -> null
        else -> error("Unexpected Time Value: $value of ${value::class.qualifiedName}")
    }
}
