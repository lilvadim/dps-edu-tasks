package ru.nsu.vadim.booking.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.nsu.vadim.booking.db.entity.BoardingPassEntity

@Repository
interface BoardingPassRepository : JpaRepository<BoardingPassEntity, BoardingPassEntity.Identifier>