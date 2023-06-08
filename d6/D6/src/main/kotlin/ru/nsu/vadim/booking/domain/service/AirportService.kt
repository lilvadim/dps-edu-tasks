package ru.nsu.vadim.booking.domain.service

import org.springframework.stereotype.Service
import ru.nsu.vadim.booking.domain.model.Airport
import ru.nsu.vadim.booking.domain.model.City
import ru.nsu.vadim.booking.domain.service.port.AirportRepositoryPort

@Service
class AirportService(
    private val airportRepositoryPort: AirportRepositoryPort
) {
    fun airports(cityName: String?): List<Airport> {
        return if (cityName != null) {
            airportRepositoryPort.findAllAirports(cityName)
        } else {
            airportRepositoryPort.findAllAirports()
        }
    }

    fun cities(): List<City> {
        return airportRepositoryPort.findAllCities()
    }
}