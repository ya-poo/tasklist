package com.yapoo.tasklist.core.time

import java.time.ZonedDateTime

fun ZonedDateTime.toEpochMilliTime() =
    EpochMilliTime(toInstant().toEpochMilli())
