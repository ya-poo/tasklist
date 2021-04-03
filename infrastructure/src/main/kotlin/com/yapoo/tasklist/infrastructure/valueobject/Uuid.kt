package com.yapoo.tasklist.infrastructure.valueobject

import jp.justincase.jackson.kotlin.textual.Textual
import java.util.*

sealed class Uuid(val value: UUID) {

    protected val string: String
        get() = value.toString()

    class User(value: UUID) : Uuid(value) {
        companion object : Textual<User> {
            override fun fromText(value: String): User = User(UUID.fromString(value))
            override val User.text: String
                get() = string
        }
    }
}
