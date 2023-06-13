package ru.nsu.vadim.booking.db.entity.projection

import com.vladmihalcea.hibernate.type.array.ListArrayType
import org.hibernate.annotations.Type
import java.time.OffsetTime

interface InboundScheduleItem {
    @get:Type(ListArrayType::class)
    val daysOfWeek: List<Int>
    val timeOfArrival: OffsetTime
    val flightNo: String
    val originAirportCode: String
}