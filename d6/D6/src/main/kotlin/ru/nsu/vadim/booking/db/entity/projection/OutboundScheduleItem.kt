package ru.nsu.vadim.booking.db.entity.projection

import com.vladmihalcea.hibernate.type.array.ListArrayType
import org.hibernate.annotations.Type
import java.time.OffsetTime

interface OutboundScheduleItem {
    @get:Type(ListArrayType::class)
    val daysOfWeek: List<Int>
    val timeOfDeparture: OffsetTime
    val flightNo: String
    val destinationAirportCode: String
}