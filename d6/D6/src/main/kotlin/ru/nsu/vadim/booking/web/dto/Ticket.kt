package ru.nsu.vadim.booking.web.dto

data class Ticket(
    var ticketNo: String,
    var bookRef: String,
    val passenger: Passenger,
)
