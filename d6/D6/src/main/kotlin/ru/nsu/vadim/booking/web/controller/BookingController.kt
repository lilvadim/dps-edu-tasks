package ru.nsu.vadim.booking.web.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.nsu.vadim.booking.domain.service.AirportService
import ru.nsu.vadim.booking.domain.service.BookingService
import ru.nsu.vadim.booking.domain.service.CheckInService
import ru.nsu.vadim.booking.domain.service.ScheduleService
import ru.nsu.vadim.booking.web.dto.*
import ru.nsu.vadim.booking.web.mapper.DtoMapper

@RestController
@RequestMapping("/api/booking")
class BookingController(
    private val airportService: AirportService,
    private val dtoMapper: DtoMapper,
    private val scheduleService: ScheduleService,
    private val bookingService: BookingService,
    private val checkInService: CheckInService,
) {
    @Operation(description = "List all available source and destination airports")
    @GetMapping("/airports")
    fun airports(@RequestParam(required = false) city: String?): List<Airport> {
        return airportService.airports(city).map { dtoMapper.mapAirport(it) }
    }

    @Operation(description = "List all the available source and destination cities")
    @GetMapping("/cities")
    fun cities(): List<City> {
        return airportService.cities().map { dtoMapper.mapCity(it) }
    }

    @Operation(description = "List the inbound schedule for an airport")
    @GetMapping("/inbound-schedule")
    fun inboundSchedule(@RequestParam(required = true) airportCode: String): List<InboundScheduleItem> {
        return scheduleService.getInboundSchedule(airportCode).map { dtoMapper.mapItem(it) }
    }

    @Operation(description = "List  the outbound schedule for an airport")
    @GetMapping("/outbound-schedule")
    fun outboundSchedule(@RequestParam(required = true) airportCode: String): List<OutboundScheduleItem> {
        return scheduleService.getOutboundSchedule(airportCode).map { dtoMapper.mapItem(it) }
    }

    @Operation(
        description = "Create a booking for a selected route for a single passenger",
        responses = [ApiResponse(responseCode = "201", description = "Created")]
    )
    @PostMapping("/bookings")
    fun createBooking(@RequestBody bookingRequest: BookingRequest): ResponseEntity<Ticket> {
        val ticket = bookingService.booking(dtoMapper.map(bookingRequest))
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(dtoMapper.map(ticket))
    }

    @Operation(description = "Online check-in for a flight")
    @PostMapping("/check-in")
    fun checkIn(@RequestBody request: CheckInRequest): ResponseEntity<BoardingPass> {
        val boardingPass = checkInService.checkIn(dtoMapper.map(request))
        return ResponseEntity.ok(dtoMapper.map(boardingPass))
    }
}