package ru.nsu.vadim.booking.domain.service

import org.springframework.stereotype.Service
import ru.nsu.vadim.booking.domain.model.BookingRequest
import ru.nsu.vadim.booking.domain.service.port.BookingRepositoryPort

@Service
class BookingService(
    private val bookingRepositoryPort: BookingRepositoryPort
) {
    fun booking(bookingRequest: BookingRequest) {
        bookingRepositoryPort.createBooking(bookingRequest)
    }
}