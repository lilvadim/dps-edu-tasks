package ru.nsu.vadim.booking.domain.service.port

import ru.nsu.vadim.booking.domain.model.BookingRequest

interface BookingRepositoryPort {
    fun createBooking(bookingRequest: BookingRequest)
}