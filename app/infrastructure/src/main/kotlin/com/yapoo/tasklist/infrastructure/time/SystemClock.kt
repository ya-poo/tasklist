package com.yapoo.tasklist.infrastructure.time

import com.yapoo.tasklist.infrastructure.valueobject.datetime.UtcDateTime
import java.time.ZonedDateTime

interface SystemClock {

    fun now(): UtcDateTime

}

internal class SystemClockImpl : SystemClock {

    override fun now(): UtcDateTime =
        UtcDateTime(defaultNow())

    private fun defaultNow(): ZonedDateTime =
        ZonedDateTime.now()
}
