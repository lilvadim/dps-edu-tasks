package ru.nsu.vadim.booking.web.dto

data class CheckInRequest(
    val ticketNo: String,
    val flightId: Long,
    val seatNo: String,
)
