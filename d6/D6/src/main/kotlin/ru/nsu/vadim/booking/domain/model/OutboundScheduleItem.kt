package ru.nsu.vadim.booking.domain.model

import java.time.DayOfWeek
import java.time.OffsetTime

data class OutboundScheduleItem(
    val daysOfWeek: List<DayOfWeek>,
    val timeOfDeparture: OffsetTime,
    val flightNo: String,
    val destinationAirportCode: String,
)
