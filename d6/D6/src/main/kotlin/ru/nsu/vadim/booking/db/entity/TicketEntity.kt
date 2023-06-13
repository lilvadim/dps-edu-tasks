package ru.nsu.vadim.booking.db.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "tickets")
class TicketEntity {

    @Id
    lateinit var ticketNo: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_ref")
    lateinit var bookRef: BookingEntity

    lateinit var passengerId: String

    lateinit var passengerName: String

    @JdbcTypeCode(SqlTypes.JSON)
    lateinit var contactData: Map<String, String>

}