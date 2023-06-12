package ru.nsu.vadim.booking.domain.service

import org.springframework.stereotype.Service
import ru.nsu.vadim.booking.domain.model.InboundScheduleItem
import ru.nsu.vadim.booking.domain.model.OutboundScheduleItem
import ru.nsu.vadim.booking.domain.service.port.FlightRepositoryPort

@Service
class ScheduleService(
    private val flightRepositoryPort: FlightRepositoryPort
) {
    fun getInboundSchedule(airportCode: String): List<InboundScheduleItem> {
        return flightRepositoryPort.findAllInboundFlights(airportCode)
    }

    fun getOutboundSchedule(airportCode: String): List<OutboundScheduleItem> {
        return flightRepositoryPort.findAllOutboundFlights(airportCode)
    }

}