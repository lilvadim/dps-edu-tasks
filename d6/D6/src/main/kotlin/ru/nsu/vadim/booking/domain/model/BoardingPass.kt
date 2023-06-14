package ru.nsu.vadim.booking.domain.model

data class BoardingPass(
    val ticketNo: String,
    val flightId: Long,
    val seatNo: String,
    val boardingNo: Int,
)
