package com.yapoo.tasklist.infrastructure.valueobject

import jp.justincase.jackson.kotlin.textual.Textual
import java.util.*
import kotlin.reflect.full.primaryConstructor

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
        val constructors by lazy {
            Uuid::class.sealedSubclasses.associateWith { kClass ->
                kClass.primaryConstructor
            }
        }
    }
}

inline fun <reified T : Uuid> UUID.toUuid(): T {
    return Uuid.constructors[T::class]
        ?.call(this) as? T
        ?: throw Exception()
}
