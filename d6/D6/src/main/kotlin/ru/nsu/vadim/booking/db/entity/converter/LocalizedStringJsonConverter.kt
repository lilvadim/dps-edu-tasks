package ru.nsu.vadim.booking.db.entity.converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import jakarta.persistence.AttributeConverter
import ru.nsu.vadim.booking.db.entity.type.LocalizedString

class LocalizedStringJsonConverter(
    private val objectMapper: ObjectMapper
) : AttributeConverter<LocalizedString, String> {
    override fun convertToDatabaseColumn(attribute: LocalizedString?): String {
        return objectMapper.writeValueAsString(attribute?.values)
    }

    override fun convertToEntityAttribute(dbData: String?): LocalizedString {
        val map: Map<String, String>? = dbData?.let { objectMapper.readValue(it) }
        return LocalizedString(map ?: emptyMap())
    }
}