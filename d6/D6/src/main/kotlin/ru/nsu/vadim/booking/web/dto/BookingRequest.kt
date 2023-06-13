package ru.nsu.vadim.booking.web.dto

data class BookingRequest(
    val flightId: Long,
    val seatNo: String,
    val fareConditions: FareConditions,
    val passenger: Passenger
)
