package ru.nsu.vadim.booking.domain.model

import java.util.*

data class Airport(
    val code: String,
    val name: LocalizedString,
    val city: City,
    val coordinates: String,
    val timeZone: TimeZone
)
