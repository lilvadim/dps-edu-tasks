package ru.nsu.vadim.booking.domain.model

import java.time.DayOfWeek
import java.time.ZonedDateTime

data class InboundScheduleItem(
    val dayOfWeek: DayOfWeek,
    val timeOfArrival: ZonedDateTime,
    val flightNo: String,
    val originAirportCode: String,
)
