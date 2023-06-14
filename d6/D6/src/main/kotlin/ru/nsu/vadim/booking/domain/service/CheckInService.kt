package ru.nsu.vadim.booking.domain.service

import org.springframework.stereotype.Service
import ru.nsu.vadim.booking.domain.model.BoardingPass
import ru.nsu.vadim.booking.domain.model.CheckInRequest
import ru.nsu.vadim.booking.domain.service.port.BoardingPassRepositoryPort

@Service
class CheckInService(
    private val boardingPassRepositoryPort: BoardingPassRepositoryPort,
) {
    fun checkIn(checkInRequest: CheckInRequest): BoardingPass {
        return boardingPassRepositoryPort.checkIn(checkInRequest)
    }
}