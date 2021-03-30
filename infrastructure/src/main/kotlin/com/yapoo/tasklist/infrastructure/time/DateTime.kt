package com.yapoo.tasklist.infrastructure.time

import org.joda.time.DateTime

fun DateTime.toZonedDateTime() =
    toGregorianCalendar()
        .toZonedDateTime()
        .withZoneSameInstant(asiaTokyoZone)
