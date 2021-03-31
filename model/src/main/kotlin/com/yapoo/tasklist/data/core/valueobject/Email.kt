package com.yapoo.tasklist.data.core.valueobject

import jp.justincase.jackson.kotlin.textual.Textual

data class Email(
    val value: String
) {
    companion object : Textual<Email> {

        override fun fromText(value: String) =
            Email(value)

        override val Email.text: String
            get() = value
    }
}
