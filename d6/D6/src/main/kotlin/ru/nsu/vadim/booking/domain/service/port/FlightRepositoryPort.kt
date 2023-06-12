package ru.nsu.vadim.booking.domain.service.port

import ru.nsu.vadim.booking.domain.model.InboundScheduleItem
import ru.nsu.vadim.booking.domain.model.OutboundScheduleItem


interface FlightRepositoryPort {

    fun findAllInboundFlights(airportCode: String): List<InboundScheduleItem>

    fun findAllOutboundFlights(airportCode: String): List<OutboundScheduleItem>

}