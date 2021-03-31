package com.yapoo.tasklist.infrastructure.time

import java.time.ZoneOffset
import java.time.ZonedDateTime

data class UtcDateTime(
    private val _value: ZonedDateTime
) {
    val value: ZonedDateTime
        get() = _value.withZoneSameInstant(ZoneOffset.UTC)
}
