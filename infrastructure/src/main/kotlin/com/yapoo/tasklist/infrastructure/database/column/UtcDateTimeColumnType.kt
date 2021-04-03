package com.yapoo.tasklist.infrastructure.database.column

import com.yapoo.tasklist.infrastructure.valueobject.datetime.UtcDateTime
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.ColumnType
import org.jetbrains.exposed.sql.Table
import java.sql.Timestamp
import java.time.ZoneOffset

fun Table.utcDateTime(name: String): Column<UtcDateTime> =
    registerColumn(name, UtcDateTimeColumnType())

class UtcDateTimeColumnType : ColumnType() {

    override fun sqlType(): String =
        "TIMESTAMP WITH TIME ZONE"

    override fun valueFromDB(value: Any): Any = when (value) {
        is UtcDateTime -> value
        is Timestamp -> value.toInstant().atZone(ZoneOffset.UTC).let(::UtcDateTime)
        else -> error("Unexpected Time Value: $value of ${value::class.qualifiedName}")
    }

    override fun notNullValueToDB(value: Any): Any = when (value) {
        is UtcDateTime -> value.value.toOffsetDateTime()
        else -> error("Unexpected Time Value: $value of ${value::class.qualifiedName}")
    }
}
