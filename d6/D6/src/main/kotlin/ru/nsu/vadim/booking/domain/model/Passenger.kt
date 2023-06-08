package ru.nsu.vadim.booking.domain.model

data class Passenger(
    val id: Long,
    val name: String,
    val contactData: ContactData,
)
