package ru.nsu.vadim.booking.web.dto

data class BoardingPass(
    val ticketNo: String,
    val flightId: Long,
    val seatNo: String,
    val boardingNo: Int,
)
