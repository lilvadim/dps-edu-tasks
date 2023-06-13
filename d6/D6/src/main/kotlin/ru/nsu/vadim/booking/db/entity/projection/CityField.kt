package ru.nsu.vadim.booking.db.entity.projection

import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

interface CityField {
    @get:JdbcTypeCode(SqlTypes.JSON)
    val city: Map<String, String>
}