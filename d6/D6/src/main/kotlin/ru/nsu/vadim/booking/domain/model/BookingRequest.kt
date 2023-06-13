package ru.nsu.vadim.booking.domain.model


data class BookingRequest(
    val flightId: Long,
    val seatNo: String,
    val fareConditions: FareConditions,
    val passenger: Passenger
)
