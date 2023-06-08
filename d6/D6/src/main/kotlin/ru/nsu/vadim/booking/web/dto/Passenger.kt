package ru.nsu.vadim.booking.web.dto

data class Passenger(
    val id: Long,
    val name: String,
    val contactData: ContactData,
)
