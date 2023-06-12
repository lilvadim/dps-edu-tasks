package ru.nsu.vadim.booking.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.nsu.vadim.booking.db.entity.FlightEntity

interface FlightRepository : JpaRepository<FlightEntity, Long> {

    fun findAllByArrivalAirportAndStatus(arrivalAirport: String, status: String): List<FlightEntity>

    fun findAllByDepartureAirportAndStatus(arrivalAirport: String, status: String): List<FlightEntity>
}