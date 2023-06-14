package ru.nsu.vadim.booking.db.adapter

import jakarta.transaction.Transactional
import org.springframework.stereotype.Component
import ru.nsu.vadim.booking.db.entity.BoardingPassEntity
import ru.nsu.vadim.booking.db.mapper.EntityMapper
import ru.nsu.vadim.booking.db.repository.BoardingPassRepository
import ru.nsu.vadim.booking.db.repository.FlightRepository
import ru.nsu.vadim.booking.db.repository.TicketRepository
import ru.nsu.vadim.booking.domain.model.BoardingPass
import ru.nsu.vadim.booking.domain.model.CheckInRequest
import ru.nsu.vadim.booking.domain.service.port.BoardingPassRepositoryPort
import kotlin.math.abs
import kotlin.random.Random

@Component
class BoardingPassRepositoryAdapter(
    private val boardingPassRepository: BoardingPassRepository,
    private val ticketRepository: TicketRepository,
    private val flightRepository: FlightRepository,
    private val entityMapper: EntityMapper,
) : BoardingPassRepositoryPort {

    @Transactional
    override fun checkIn(checkInRequest: CheckInRequest): BoardingPass {
        var boardingPassEntity = entityMapper.map(checkInRequest)
        boardingPassEntity.boardingNo = abs(Random.nextInt())

        validate(boardingPassEntity)

        boardingPassEntity = boardingPassRepository.save(boardingPassEntity)

        return entityMapper.map(boardingPassEntity)
    }

    private fun validate(boardingPassEntity: BoardingPassEntity) {
        val ticketNo = boardingPassEntity.ticketNo
        ticketRepository.findById(ticketNo).orElseThrow {
            IllegalArgumentException("Ticket with ticketNo $ticketNo not found")
        }

        val flightId = boardingPassEntity.flightId
        flightRepository.findById(flightId).orElseThrow {
            IllegalArgumentException("Flight with flightId $flightId not found")
        }
    }
}