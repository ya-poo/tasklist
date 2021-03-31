package com.yapoo.tasklist.infrastructure.time

import java.time.ZonedDateTime

interface SystemClock {

    fun now(): UtcDateTime

}

class SystemClockImpl : SystemClock {

    override fun now(): UtcDateTime =
        UtcDateTime(defaultNow())

    private fun defaultNow(): ZonedDateTime =
        ZonedDateTime.now()
}
