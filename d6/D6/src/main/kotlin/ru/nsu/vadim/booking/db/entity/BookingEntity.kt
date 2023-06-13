package ru.nsu.vadim.booking.db.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.ZonedDateTime

@Entity
@Table(name = "bookings")
class BookingEntity {

    @Id
    lateinit var bookRef: String

    lateinit var bookDate: ZonedDateTime

    lateinit var totalAmount: BigDecimal
}