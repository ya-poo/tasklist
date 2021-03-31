package com.yapoo.tasklist.infrastructure.valueobject.datetime

import jp.justincase.jackson.kotlin.textual.Textual
import java.time.ZoneId
import java.time.ZonedDateTime

data class TokyoDateTime(
    private val _value: ZonedDateTime
) : AbstractDateTime(_value, ZoneId.of("Asia/Tokyo")) {

    companion object : Textual<TokyoDateTime> {

        override fun fromText(value: String): TokyoDateTime =
            TokyoDateTime(ZonedDateTime.parse(value, formatter))

        override val TokyoDateTime.text: String
            get() = formattedString
    }
}
