package ru.nsu.vadim.booking.db.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "flights", schema = "bookings")
class FlightEntity {
    @Id
    @Column(name = "flight_id")
    var id: Long = 0

    lateinit var flightNo: String

    lateinit var scheduledDeparture: ZonedDateTime

    lateinit var scheduledArrival: ZonedDateTime

    lateinit var departureAirport: String

    lateinit var arrivalAirport: String

    lateinit var status: String

    lateinit var aircraftCode: String
}