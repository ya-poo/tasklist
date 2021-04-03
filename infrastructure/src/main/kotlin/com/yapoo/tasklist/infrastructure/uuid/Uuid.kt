package com.yapoo.tasklist.infrastructure.uuid

import java.util.*

abstract class Uuid {
    abstract val value: UUID

    val string: String
        get() = value.toString()
}
