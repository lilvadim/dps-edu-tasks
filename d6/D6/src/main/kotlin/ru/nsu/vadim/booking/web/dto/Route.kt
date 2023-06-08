package ru.nsu.vadim.booking.web.dto

import java.time.LocalDateTime

data class Route(
    val flightNo: String,
    val departureTime: LocalDateTime,
    val arrivalTime: LocalDateTime,
    val origin: String,
    val destination: String,
)
