package ru.nsu.vadim.booking.db.adapter

import jakarta.transaction.Transactional
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Component
import ru.nsu.vadim.booking.db.entity.BookingEntity
import ru.nsu.vadim.booking.db.entity.PriceEntity
import ru.nsu.vadim.booking.db.entity.TicketEntity
import ru.nsu.vadim.booking.db.entity.TicketFlightEntity
import ru.nsu.vadim.booking.db.mapper.EntityMapper
import ru.nsu.vadim.booking.db.repository.*
import ru.nsu.vadim.booking.domain.model.BookingRequest
import ru.nsu.vadim.booking.domain.model.Ticket
import ru.nsu.vadim.booking.domain.service.port.BookingRepositoryPort
import java.time.ZonedDateTime

@Component
class BookingRepositoryPortAdapter(
    private val bookingRepository: BookingRepository,
    private val ticketRepository: TicketRepository,
    private val ticketFlightRepository: TicketFlightRepository,
    private val flightRepository: FlightRepository,
    private val priceRepository: PriceRepository,
    private val entityMapper: EntityMapper,
) : BookingRepositoryPort {

    @Transactional
    override fun createBooking(bookingRequest: BookingRequest): Ticket {
        val flightId = bookingRequest.flightId

        val flightEntity = flightRepository.findById(flightId).orElseThrow()

        val price = priceRepository.findById(
            PriceEntity.Identifier().apply {
                flightNo = flightEntity.flightNo
                seatNo = bookingRequest.seatNo
                fareConditions = bookingRequest.fareConditions.toString()
            }
        ).orElseThrow()

        val amount = price.amounts.min()

        var bookingEntity = BookingEntity().apply {
            bookRef = RandomStringUtils.randomAlphanumeric(6).uppercase()
            totalAmount = amount.toBigDecimal()
            bookDate = ZonedDateTime.now()
        }

        bookingEntity = bookingRepository.save(bookingEntity)

        var ticketEntity = TicketEntity().apply {
            ticketNo = RandomStringUtils.randomNumeric(13)
            bookRef = bookingEntity
            passengerId = bookingRequest.passenger.id
            passengerName = bookingRequest.passenger.name
            contactData = mapOf(
                "phone" to bookingRequest.passenger.contactData.phone,
                "email" to bookingRequest.passenger.contactData.email,
            )
        }

        ticketEntity = ticketRepository.save(ticketEntity)

        val ticketFlightEntity = TicketFlightEntity().apply {
            ticketNo = ticketEntity.ticketNo
            this.flightId = flightEntity.id
            fareConditions = price.fareConditions
            this.amount = amount.toBigDecimal()
        }

        ticketFlightRepository.save(ticketFlightEntity)

        return entityMapper.map(ticketEntity)
    }

}