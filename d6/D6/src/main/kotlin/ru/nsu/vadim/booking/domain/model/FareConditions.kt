package ru.nsu.vadim.booking.domain.model

enum class FareConditions {
    BUSINESS,
    ECONOMY,
    COMFORT;

    override fun toString(): String {
        return name.lowercase().replaceFirstChar { it.titlecase() }
    }
}