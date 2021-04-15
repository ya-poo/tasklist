package com.yapoo.tasklist.infrastructure.uuid

import java.util.*

interface UuidFactory {

    fun next(): UUID

}

internal class UuidFactoryImpl : UuidFactory {

    override fun next(): UUID =
        UUID.randomUUID()
}
