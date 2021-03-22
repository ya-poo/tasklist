package com.yapoo.tasklist.infrastructure.time

import java.time.ZonedDateTime

interface SystemClock {

    fun now(): ZonedDateTime

}

class SystemClockImpl : SystemClock {

    override fun now(): ZonedDateTime =
        ZonedDateTime.now(asiaTokyoZone)

}
