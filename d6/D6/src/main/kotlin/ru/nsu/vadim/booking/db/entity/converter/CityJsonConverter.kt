package ru.nsu.vadim.booking.db.entity.converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.persistence.AttributeConverter
import ru.nsu.vadim.booking.db.entity.type.City
import ru.nsu.vadim.booking.db.entity.type.LocalizedString

class CityJsonConverter(
    private val objectMapper: ObjectMapper,
) : AttributeConverter<City, String> {
    override fun convertToDatabaseColumn(attribute: City?): String {
        return objectMapper.writeValueAsString(attribute?.name?.values)
    }

    override fun convertToEntityAttribute(dbData: String?): City {
        val name: Map<String, String>? = dbData?.let { objectMapper.readValue(it) }
        return City(name = LocalizedString(name ?: emptyMap()));
    }
}