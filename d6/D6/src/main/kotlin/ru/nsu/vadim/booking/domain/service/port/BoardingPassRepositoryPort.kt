package ru.nsu.vadim.booking.domain.service.port

import ru.nsu.vadim.booking.domain.model.BoardingPass
import ru.nsu.vadim.booking.domain.model.CheckInRequest

interface BoardingPassRepositoryPort {
    fun checkIn(checkInRequest: CheckInRequest): BoardingPass
}