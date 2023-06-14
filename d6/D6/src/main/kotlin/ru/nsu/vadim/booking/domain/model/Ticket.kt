package ru.nsu.vadim.booking.domain.model

data class Ticket(
    var ticketNo: String,
    var bookRef: String,
    val passenger: Passenger,
)
