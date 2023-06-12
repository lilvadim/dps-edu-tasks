package ru.nsu.vadim.booking.web.dto

import java.time.DayOfWeek
import java.time.ZonedDateTime

data class OutboundScheduleItem(
    val dayOfWeek: DayOfWeek,
    val timeOfDeparture: ZonedDateTime,
    val flightNo: String,
    val destinationAirportCode: String,
)
