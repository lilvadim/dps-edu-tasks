package ru.nsu.vadim.booking.db.adapter

import org.springframework.stereotype.Component
import ru.nsu.vadim.booking.db.mapper.EntityMapper
import ru.nsu.vadim.booking.db.repository.FlightRepository
import ru.nsu.vadim.booking.domain.model.InboundScheduleItem
import ru.nsu.vadim.booking.domain.model.OutboundScheduleItem
import ru.nsu.vadim.booking.domain.service.port.FlightRepositoryPort

@Component
class FlightRepositoryAdapter(
    private val flightRepository: FlightRepository,
    private val entityMapper: EntityMapper
) : FlightRepositoryPort {
    override fun findAllInboundFlights(airportCode: String): List<InboundScheduleItem> {
        return flightRepository.findInboundFlights(airportCode).map { entityMapper.map(it) }
    }

    override fun findAllOutboundFlights(airportCode: String): List<OutboundScheduleItem> {
        return flightRepository.findOutboundFlights(airportCode).map { entityMapper.map(it) }
    }
}