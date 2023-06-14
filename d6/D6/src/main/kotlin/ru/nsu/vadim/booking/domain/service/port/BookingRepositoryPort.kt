package ru.nsu.vadim.booking.domain.service.port

import ru.nsu.vadim.booking.domain.model.BookingRequest
import ru.nsu.vadim.booking.domain.model.Ticket

interface BookingRepositoryPort {
    fun createBooking(bookingRequest: BookingRequest): Ticket
}