package com.yapoo.tasklist.infrastructure.valueobject.datetime

import jp.justincase.jackson.kotlin.textual.Textual
import java.time.ZoneOffset
import java.time.ZonedDateTime

data class UtcDateTime(
    private val _value: ZonedDateTime
) : AbstractDateTime(_value, ZoneOffset.UTC) {

    companion object : Textual<UtcDateTime> {

        override fun fromText(value: String): UtcDateTime =
            UtcDateTime(ZonedDateTime.parse(value, formatter))

        override val UtcDateTime.text: String
            get() = formattedString
    }

    fun toTokyoDateTime(): TokyoDateTime =
        TokyoDateTime(_value)
}
