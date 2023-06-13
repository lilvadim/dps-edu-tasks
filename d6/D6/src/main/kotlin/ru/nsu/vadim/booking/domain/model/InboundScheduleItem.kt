package ru.nsu.vadim.booking.domain.model

import java.time.DayOfWeek
import java.time.OffsetTime

data class InboundScheduleItem(
    val daysOfWeek: List<DayOfWeek>,
    val timeOfArrival: OffsetTime,
    val flightNo: String,
    val originAirportCode: String,
)
