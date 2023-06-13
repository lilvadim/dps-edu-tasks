package ru.nsu.vadim.booking.db.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.nsu.vadim.booking.db.entity.AirportEntity
import ru.nsu.vadim.booking.db.entity.projection.CityField

@Repository
interface AirportRepository : JpaRepository<AirportEntity, String> {
    fun findAllBy(): List<CityField>

    @Query("SELECT * FROM airports_data WHERE city ->> 'en' = ? OR city ->> 'ru' = ?", nativeQuery = true)
    fun findAllByAnyCityName(cityNameEn: String, cityNameRu: String): List<AirportEntity>
}