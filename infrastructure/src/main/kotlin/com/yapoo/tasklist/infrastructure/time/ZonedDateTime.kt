package com.yapoo.tasklist.infrastructure.time

import java.time.ZonedDateTime

fun ZonedDateTime.toEpochMilliTime() =
    EpochMilliTime(toInstant().toEpochMilli())
