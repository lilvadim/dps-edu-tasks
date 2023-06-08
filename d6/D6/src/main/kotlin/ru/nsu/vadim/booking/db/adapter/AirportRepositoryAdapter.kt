package ru.nsu.vadim.booking.db.adapter

import org.springframework.stereotype.Component
import ru.nsu.vadim.booking.db.mapper.EntityMapper
import ru.nsu.vadim.booking.db.repository.AirportRepository
import ru.nsu.vadim.booking.domain.model.Airport
import ru.nsu.vadim.booking.domain.model.City
import ru.nsu.vadim.booking.domain.service.port.AirportRepositoryPort

@Component
class AirportRepositoryAdapter(
    private val airportRepository: AirportRepository,
    private val entityMapper: EntityMapper
) : AirportRepositoryPort {

    override fun findAllAirports(): List<Airport> {
        return airportRepository.findAll().map { entityMapper.mapAirportEntity(it) }
    }

    override fun findAllAirports(cityName: String): List<Airport> {
        return airportRepository.findAllByAnyCityName(cityName, cityName).map { entityMapper.mapAirportEntity(it) }
    }

    override fun findAllCities(): List<City> {
        return airportRepository.findAllBy().map { entityMapper.mapCity(it) }
    }
}