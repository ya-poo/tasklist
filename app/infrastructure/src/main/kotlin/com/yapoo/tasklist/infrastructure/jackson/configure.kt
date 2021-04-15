package com.yapoo.tasklist.infrastructure.jackson

import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import jp.justincase.jackson.kotlin.textual.codec.TextualModule

internal fun ObjectMapper.configure() {
    setDefaultPrettyPrinter(DefaultPrettyPrinter().apply {
        indentArraysWith(DefaultPrettyPrinter.FixedSpaceIndenter.instance)
        indentObjectsWith(DefaultIndenter("  ", "\n"))
    })

    registerModule(Jdk8Module())
    registerModule(TextualModule())

    configure(SerializationFeature.INDENT_OUTPUT, true)
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
    configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
    propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
}
