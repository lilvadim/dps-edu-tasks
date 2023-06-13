package ru.nsu.vadim.booking.db.entity

import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "airports_data", schema = "bookings")
class AirportEntity {
    @Id
    @Column(name = "airport_code")
    lateinit var code: String

    @Column(name = "airport_name")
    @JdbcTypeCode(SqlTypes.JSON)
    lateinit var name: Map<String, String>

    @JdbcTypeCode(SqlTypes.JSON)
    lateinit var city: Map<String, String>

    lateinit var coordinates: String

    lateinit var timezone: String
}