package com.yapoo.tasklist.model.valueobject

import com.yapoo.tasklist.infrastructure.uuid.Uuid
import jp.justincase.jackson.kotlin.textual.Textual
import java.util.*

data class UserId(
    override val value: UUID
) : Uuid() {

    companion object : Textual<UserId> {
        override fun fromText(value: String) = UserId(UUID.fromString(value))

        override val UserId.text: String
            get() = string
    }
}
