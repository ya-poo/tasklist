package com.yapoo.tasklist.infrastructure.time

import jp.justincase.jackson.kotlin.textual.Textual
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

data class UtcDateTime(
    private val _value: ZonedDateTime
) {
    val value: ZonedDateTime
        get() = _value
            .withZoneSameInstant(ZoneOffset.UTC)
            .truncatedTo(ChronoUnit.MICROS)

    companion object : Textual<UtcDateTime> {

        private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

        override fun fromText(value: String): UtcDateTime =
            UtcDateTime(ZonedDateTime.parse(value, formatter))

        override val UtcDateTime.text: String
            get() = value.format(formatter)
    }
}
