package ru.nsu.vadim.booking.db.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity
@Table(name = "aircrafts_data")
class AircraftEntity {
    @Id
    @Column(name = "aircraft_code")
    lateinit var code: String

    @Column(name = "model")
    @JdbcTypeCode(SqlTypes.JSON)
    lateinit var name: Map<String, String>
}