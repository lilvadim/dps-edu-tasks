package ru.nsu.vadim.booking.db.adapter

import org.springframework.stereotype.Component
import ru.nsu.vadim.booking.db.mapper.EntityMapper
import ru.nsu.vadim.booking.db.repository.FlightRepository
import ru.nsu.vadim.booking.domain.model.InboundScheduleItem
import ru.nsu.vadim.booking.domain.model.OutboundScheduleItem
import ru.nsu.vadim.booking.domain.service.port.FlightRepositoryPort

const val SCHEDULED_STATUS = "Scheduled"

@Component
class FlightRepositoryAdapter(
    private val flightRepository: FlightRepository,
    private val entityMapper: EntityMapper
) : FlightRepositoryPort {
    override fun findAllInboundFlights(airportCode: String): List<InboundScheduleItem> {
        return flightRepository.findAllByArrivalAirportAndStatus(airportCode, SCHEDULED_STATUS)
            .map { entityMapper.mapToInboundScheduleItem(it) }
    }

    override fun findAllOutboundFlights(airportCode: String): List<OutboundScheduleItem> {
        return flightRepository.findAllByDepartureAirportAndStatus(airportCode, SCHEDULED_STATUS)
            .map { entityMapper.mapToOutboundScheduleItem(it) }
    }
}