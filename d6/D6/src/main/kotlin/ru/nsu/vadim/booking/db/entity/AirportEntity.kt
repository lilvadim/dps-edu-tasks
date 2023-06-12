package ru.nsu.vadim.booking.db.entity

import jakarta.persistence.*
import ru.nsu.vadim.booking.db.entity.converter.CityJsonConverter
import ru.nsu.vadim.booking.db.entity.converter.LocalizedStringJsonConverter
import ru.nsu.vadim.booking.db.entity.type.City
import ru.nsu.vadim.booking.db.entity.type.LocalizedString

@Entity
@Table(name = "airports_data", schema = "bookings")
class AirportEntity {
    @Id
    @Column(name = "airport_code")
    lateinit var code: String

    @Column(name = "airport_name")
    @Convert(converter = LocalizedStringJsonConverter::class)
    lateinit var name: LocalizedString

    @Convert(converter = CityJsonConverter::class)
    lateinit var city: City

    lateinit var coordinates: String

    lateinit var timezone: String
}