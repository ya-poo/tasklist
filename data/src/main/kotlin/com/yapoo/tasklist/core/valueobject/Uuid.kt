package com.yapoo.tasklist.core.valueobject

import java.util.*

sealed class Uuid(private val value: UUID) : Comparable<Uuid> {

    override fun compareTo(other: Uuid): Int =
        if (javaClass == other.javaClass) {
            value.compareTo(other.value)
        } else {
            javaClass.name.compareTo(other.javaClass.name)
        }

    class User(value: UUID) : Uuid(value)
}
