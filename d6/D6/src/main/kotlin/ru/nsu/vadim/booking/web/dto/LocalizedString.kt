package ru.nsu.vadim.booking.web.dto

import com.fasterxml.jackson.annotation.JsonValue

data class LocalizedString(
    @JsonValue
    val values: Map<String, String>
)
