package com.yapoo.tasklist.infrastructure.time

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

abstract class AbstractDateTime(
    _value: ZonedDateTime,
    zoneId: ZoneId
) {
    val value: ZonedDateTime = _value
        .withZoneSameInstant(zoneId)
        .truncatedTo(ChronoUnit.MICROS)

    protected val formattedString: String
        get() = value.format(formatter)

    companion object {

        val formatter: DateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    }
}
