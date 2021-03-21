package com.yapoo.tasklist.core.time

import java.time.Instant
import java.time.ZonedDateTime

inline class EpochMilliTime(
    val value: Long
) {

    fun toZonedDateTime(): ZonedDateTime =
        ZonedDateTime.ofInstant(Instant.ofEpochMilli(value), asiaTokyoZone)
}
