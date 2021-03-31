package com.yapoo.tasklist.infrastructure.valueobject

import jp.justincase.jackson.kotlin.textual.Textual
import java.util.*

sealed class Uuid(val value: UUID) : Comparable<Uuid> {

    override fun compareTo(other: Uuid): Int =
        if (javaClass == other.javaClass) {
            value.compareTo(other.value)
        } else {
            javaClass.name.compareTo(other.javaClass.name)
        }

    protected val string: String
        get() = value.toString()

    class User(value: UUID) : Uuid(value) {
        companion object : Textual<User> {
            override fun fromText(value: String): User = User(UUID.fromString(value))
            override val User.text: String
                get() = string
        }
    }

    companion object {
        inline fun <reified T : Uuid> random(): T {
            val constructor = T::class.java.getConstructor(UUID::class.java)
            return constructor.newInstance(UUID.randomUUID())
        }
    }
}
