package ru.nsu.vadim.booking.domain.model

data class CheckInRequest(
    val ticketNo: String,
    val flightId: Long,
    val seatNo: String,
)
