package com.yapoo.tasklist.infrastructure.jackson

import com.fasterxml.jackson.core.util.DefaultIndenter
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import jp.justincase.jackson.kotlin.textual.codec.TextualModule

internal fun ObjectMapper.configure() {
    setDefaultPrettyPrinter(DefaultPrettyPrinter().apply {
        indentArraysWith(DefaultPrettyPrinter.FixedSpaceIndenter.instance)
        indentObjectsWith(DefaultIndenter("  ", "\n"))
    })

    registerKotlinModule()
    registerModule(TextualModule())

    configure(SerializationFeature.INDENT_OUTPUT, true)
    configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
    propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
}
