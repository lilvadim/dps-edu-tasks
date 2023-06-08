package ru.nsu.vadim.booking.domain.service.port

import ru.nsu.vadim.booking.domain.model.Airport
import ru.nsu.vadim.booking.domain.model.City

interface AirportRepositoryPort {
    fun findAllAirports(): List<Airport>

    fun findAllAirports(cityName: String): List<Airport>

    fun findAllCities(): List<City>
}