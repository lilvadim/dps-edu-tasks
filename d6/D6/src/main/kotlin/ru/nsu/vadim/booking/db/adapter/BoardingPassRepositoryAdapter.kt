package ru.nsu.vadim.booking.db.adapter

import jakarta.transaction.Transactional
import org.springframework.stereotype.Component
import ru.nsu.vadim.booking.db.mapper.EntityMapper
import ru.nsu.vadim.booking.db.repository.BoardingPassRepository
import ru.nsu.vadim.booking.domain.model.BoardingPass
import ru.nsu.vadim.booking.domain.model.CheckInRequest
import ru.nsu.vadim.booking.domain.service.port.BoardingPassRepositoryPort
import kotlin.math.abs
import kotlin.random.Random

@Component
class BoardingPassRepositoryAdapter(
    private val boardingPassRepository: BoardingPassRepository,
    private val entityMapper: EntityMapper,
) : BoardingPassRepositoryPort {

    @Transactional
    override fun checkIn(checkInRequest: CheckInRequest): BoardingPass {
        var boardingPassEntity = entityMapper.map(checkInRequest)
        boardingPassEntity.boardingNo = abs(Random.nextInt())

        boardingPassEntity = boardingPassRepository.save(boardingPassEntity)

        return entityMapper.map(boardingPassEntity)
    }
}