package ru.nsu.vadim.booking.db.entity.projection

import com.vladmihalcea.hibernate.type.array.ListArrayType
import jakarta.persistence.Column
import org.hibernate.annotations.Type
import java.time.OffsetTime

interface InboundScheduleItem {
    @get:Type(ListArrayType::class)
    val daysOfWeek: List<Int>

    @get:Column(columnDefinition = "TIME WITH TIME ZONE")
    val timeOfArrival: OffsetTime
    val flightNo: String
    val originAirportCode: String
}