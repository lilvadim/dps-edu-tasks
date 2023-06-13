package ru.nsu.vadim.booking.db.entity

import jakarta.persistence.*
import java.io.Serializable
import java.math.BigDecimal

@Entity
@Table(name = "ticket_flights")
@IdClass(TicketFlightEntity.Identifier::class)
class TicketFlightEntity {

    data class Identifier(
        var ticketNo: String = "",
        var flightId: Long = 0L
    ) : Serializable

    @Id
    @Column(name = "ticket_no")
    lateinit var ticketNo: String

    @Id
    @Column(name = "flight_id")
    var flightId: Long = 0L

    lateinit var fareConditions: String

    lateinit var amount: BigDecimal
}