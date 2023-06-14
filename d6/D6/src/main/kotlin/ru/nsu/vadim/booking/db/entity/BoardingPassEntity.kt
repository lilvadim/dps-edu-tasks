package ru.nsu.vadim.booking.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "boarding_passes")
@IdClass(BoardingPassEntity.Identifier::class)
class BoardingPassEntity {
    data class Identifier(
        var ticketNo: String = "",
        var flightId: Long = 0L
    ) : Serializable

    @Id
    lateinit var ticketNo: String

    @Id
    var flightId: Long = 0L

    var boardingNo: Int = 0

    lateinit var seatNo: String
}