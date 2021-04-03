package com.yapoo.tasklist.infrastructure.uuid

import java.util.*

interface Uuid {
    val value: UUID

    val string: String
        get() = value.toString()
}
